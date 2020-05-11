package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.exception.NotFoundException;

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
        FileEntity fileEntity= FileMapper.toFileEntity(file);
        fileEntity.setUserEntity(userEntity);

        return FileMapper.toFile(fileRepository.save(fileEntity));
    }

    public List<File> getAll() {
        UserEntity userEntity = UserEntity.UserEntityBuilder.create()
                .withUsername(userService.getCurrentUserId())
                .build();
        return FileMapper.toFilesList(fileRepository.findAllByUserEntity(userEntity));
    }

    public File getFile(String fileId) {
        return FileMapper.toFile(fileRepository.findById(fileId)
                .orElseThrow(() -> new NotFoundException("File not found with id " + fileId)));
    }

    public File update(File file) {
        if(file.getId() == null){
            throw new NotFoundException("File not found with id " + file.getId());
        }
        if (!fileRepository.existsById(file.getId())) {
            throw new NotFoundException("File not found with id " + file.getId());
        }

        File currentFile = FileMapper.toFile(fileRepository.getOne(file.getId()));
        File newFile = currentFile.mergeWith(file);

        return FileMapper.toFile(fileRepository.save(FileMapper.toFileEntity(newFile)));
    }

    public File delete(String fileId){
        File file = FileMapper.toFile(fileRepository.getOne(fileId));
        if(!fileRepository.existsById(file.getId())) {
            fileRepository.deleteById(file.getId());
        }
        return file;
    }
}
