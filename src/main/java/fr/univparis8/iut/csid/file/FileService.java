package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.folder.FolderModel;
import fr.univparis8.iut.csid.folder.FolderMapper;
import fr.univparis8.iut.csid.user.UserEntity;
import fr.univparis8.iut.csid.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;
    private final UserService userService;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;


    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public FileService(FileRepository fileRepository, UserService userService) {
        this.fileRepository = fileRepository;
        this.userService = userService;
    }

    public List<FileModel> findAll() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FileMapper.FileEntityListToFileModelList(fileRepository.findAllByUserEntity(userEntity, Sort.by(Sort.Direction.DESC, "addedDate")));
    }

    public FileModel getById(String fileId) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FileMapper.toFileModel(fileRepository.getByIdAndUserEntity(fileId, userEntity));
    }

    public List<FileModel> findAllByFolderEntity(FolderModel folderModel) {
        List<FileEntity> fileEntities = fileRepository.findAllByFolderEntity(FolderMapper.toFolderEntity(folderModel), Sort.by(Sort.Direction.DESC, "addedDate"));
        return FileMapper.FileEntityListToFileModelList(fileEntities);
    }

    public List<String> findAllCompanies() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return fileRepository.findCompaniesByUserEntity(userEntity);
    }

    public List<String> findAllWorkplaces() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return fileRepository.findWorkplacesByUserEntity(userEntity);
    }

    public List<FileModel> saveAll(List<FileModel> fileModels) {
        List<FileEntity> fileEntities = FileMapper.toFileEntityList(fileModels);
        Date dateNow = new Date();
        for (FileEntity fileEntity : fileEntities) {
            fileEntity.setUserEntity(userService.getCurrentUserEntity());
            fileEntity.setAddedDate(dateNow);
        }
        return FileMapper.FileEntityListToFileModelList(fileRepository.saveAll(fileEntities));
    }

    public FileModel update(FileModel fileModel) {
        FileModel currentFileModel = this.getById(fileModel.getId());

        FileEntity newFile = FileMapper.toFileEntity(currentFileModel.mergeWith(fileModel));

        UserEntity userEntity = userService.getCurrentUserEntity();
        newFile.setUserEntity(userEntity);
        return FileMapper.toFileModel(fileRepository.save(newFile));
    }

    public void deleteInBatch(List<FileModel> fileModels) {
        List<FileEntity> fileEntities = FileMapper.toFileEntityList(fileModels);
        fileRepository.deleteInBatch(fileEntities);
    }
}
