package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.folder.Folder;
import fr.univparis8.iut.csid.folder.FolderMapper;
import fr.univparis8.iut.csid.user.UserEntity;
import fr.univparis8.iut.csid.user.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;
    private final UserService userService;

    public FileService(FileRepository fileRepository, UserService userService) {
        this.fileRepository = fileRepository;
        this.userService = userService;
    }

    public List<File> findAll() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FileMapper.FileEntityListToFileList(fileRepository.findAllByUserEntity(userEntity, Sort.by(Sort.Direction.DESC, "addedDate")));
    }

    public File getById(String fileId) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FileMapper.toFile(fileRepository.getByIdAndUserEntity(fileId, userEntity));
    }

    public List<File> findAllByFolderEntity(Folder folder) {
        List<FileEntity> fileEntities = fileRepository.findAllByFolderEntity(FolderMapper.toFolderEntity(folder), Sort.by(Sort.Direction.DESC, "addedDate"));
        return FileMapper.FileEntityListToFileList(fileEntities);
    }

    public List<String> findAllCompanies() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return fileRepository.findCompaniesByUserEntity(userEntity);
    }

    public List<String> findAllWorkplaces() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return fileRepository.findWorkplacesByUserEntity(userEntity);
    }

    public List<File> saveAll(List<File> files) {
        List<FileEntity> fileEntities = FileMapper.toFileEntityList(files);
        Date dateNow = new Date();
        for (FileEntity fileEntity : fileEntities) {
            fileEntity.setUserEntity(userService.getCurrentUserEntity());
            fileEntity.setAddedDate(dateNow);
        }
        return FileMapper.FileEntityListToFileList(fileRepository.saveAll(fileEntities));
    }

    public File update(File file) {
        File currentFile = this.getById(file.getId());

        FileEntity newFile = FileMapper.toFileEntity(currentFile.mergeWith(file));

        UserEntity userEntity = userService.getCurrentUserEntity();
        newFile.setUserEntity(userEntity);
        return FileMapper.toFile(fileRepository.save(newFile));
    }

    public void deleteInBatch(List<File> files) {
        List<FileEntity> fileEntities = FileMapper.toFileEntityList(files);
        fileRepository.deleteInBatch(fileEntities);
    }
}
