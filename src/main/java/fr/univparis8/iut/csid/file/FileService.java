package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.exception.NotFoundException;
import fr.univparis8.iut.csid.folder.Folder;
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

    public FileService(FileRepository fileRepository, UserService userService) {
        this.fileRepository = fileRepository;
        this.userService = userService;
    }

    public List<File> findAll() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FileMapper.toFileList(fileRepository.findAllByUserEntity(userEntity, Sort.by(Sort.Direction.DESC, "addedDate")));
    }

    public File findById(String fileId) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FileMapper.toFile(fileRepository.findByIdAndUserEntity(fileId, userEntity)
                .orElseThrow(() -> new NotFoundException("File not found with id " + fileId + " for user " + userEntity.getUsername())));
    }

    public List<File> findAllByFolderEntity(Folder folder) {
        List<FileEntity> fileEntities = fileRepository.findAllByFolderEntity(FolderMapper.toFolderEntity(folder), Sort.by(Sort.Direction.DESC, "addedDate"));
        return FileMapper.toFileList(fileEntities);
    }

    public List<String> findAllCompanies() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return fileRepository.findCompaniesByUserEntity(userEntity);
    }

    public List<String> findAllWorkplaces() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return fileRepository.findWorkplacesByUserEntity(userEntity);
    }

    public List<File> save(List<File> files) {
        List<FileEntity> fileEntities = FileMapper.toFileEntitiesList(files);
        Date dateNow = new Date();
        for(FileEntity fileEntity : fileEntities){
            fileEntity.setUserEntity(userService.getCurrentUserEntity());
            fileEntity.setAddedDate(dateNow);
        }
        return FileMapper.toFileList(fileRepository.saveAll(fileEntities));
    }

    public File update(File file) {
        if (file.getId() == null) {
            throw new NotFoundException("File not found with id " + file.getId());
        }

        File currentFile = this.findById(file.getId());

        FileEntity newFile = FileMapper.toFileEntity(currentFile.mergeWith(file));

        UserEntity userEntity = userService.getCurrentUserEntity();
        newFile.setUserEntity(userEntity);
        return FileMapper.toFile(fileRepository.save(newFile));
    }

    public void delete(String[] fileIds) throws SQLException {
        String sql = "DELETE FROM file where id=?";
        PreparedStatement preparedStatement = null;
        Connection connection = DriverManager.getConnection(this.dbUrl, this.dbUsername, this.dbPassword);
        preparedStatement = connection.prepareStatement(sql);

        for (String fileId : fileIds) {
            preparedStatement.setString(1, fileId);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
    }
}
