package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.exception.NotFoundException;

import fr.univparis8.iut.csid.folder.Folder;
import fr.univparis8.iut.csid.folder.FolderMapper;
import fr.univparis8.iut.csid.user.UserEntity;
import fr.univparis8.iut.csid.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;
    private final UserService userService;

    public FileService(FileRepository fileRepository, UserService userService) {
        this.fileRepository = fileRepository;
        this.userService = userService;
    }

    public File saveFile(File file) {
        UserEntity userEntity = UserEntity.UserEntityBuilder.create()
                .withUsername(userService.getCurrentUserId())
                .build();
        FileEntity fileEntity = FileMapper.toFileEntity(file);
        fileEntity.setUserEntity(userEntity);

        FileEntity fileEntityResponse = fileRepository.save(fileEntity);

        return FileMapper.toFile(fileEntityResponse);
    }

    public List<File> getAll() {
        UserEntity userEntity = UserEntity.UserEntityBuilder.create()
                .withUsername(userService.getCurrentUserId())
                .build();
        return FileMapper.toFileList(fileRepository.findAllByUserEntity(userEntity));
    }

    public File getFile(String fileId) {
        return FileMapper.toFile(fileRepository.findById(fileId)
                .orElseThrow(() -> new NotFoundException("File not found with id " + fileId)));
    }

    public List<File> getByFolder(Folder folder){
        List<FileEntity> fileEntities = fileRepository.findAllByFolderEntity(FolderMapper.toFolderEntity(folder));
        return FileMapper.toFileList(fileEntities);
    }

    public List<String> getCompanies(){
        UserEntity userEntity = UserEntity.UserEntityBuilder.create()
                .withUsername(userService.getCurrentUserId())
                .build();
        return fileRepository.findCompaniesByUserEntity(userEntity);
    }

    public List<String> getWorkplaces(){
        UserEntity userEntity = UserEntity.UserEntityBuilder.create()
                .withUsername(userService.getCurrentUserId())
                .build();
        return fileRepository.findWorkplacesByUserEntity(userEntity);
    }

    public File update(File file) {
        if (file.getId() == null) {
            throw new NotFoundException("File not found with id " + file.getId());
        }
        if (!fileRepository.existsById(file.getId())) {
            throw new NotFoundException("File not found with id " + file.getId());
        }

        File currentFile = FileMapper.toFile(fileRepository.getOne(file.getId()));

        FileEntity newFile = FileMapper.toFileEntity(currentFile.mergeWith(file));

        UserEntity userEntity = UserEntity.UserEntityBuilder.create()
                .withUsername(userService.getCurrentUserId())
                .build();
        newFile.setUserEntity(userEntity);
        return FileMapper.toFile(fileRepository.save(newFile));
    }

    public File delete(String fileId) {
        File file = FileMapper.toFile(fileRepository.getOne(fileId));
        System.out.println(fileRepository.existsById(file.getId()));
        if (fileRepository.existsById(file.getId())) {
            fileRepository.deleteById(file.getId());
        }
        return file;
    }
}
