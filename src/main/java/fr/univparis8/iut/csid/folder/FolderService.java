package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.exception.NotFoundException;
import fr.univparis8.iut.csid.user.UserEntity;
import fr.univparis8.iut.csid.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    private final FolderRepository folderRepository;
    private final UserService userService;


    public FolderService(FolderRepository folderRepository, UserService userService) {
        this.folderRepository = folderRepository;
        this.userService = userService;
    }

    public Folder save(Folder folder) {
        UserEntity userEntity = UserEntity.UserEntityBuilder.create()
                .withUsername(userService.getCurrentUserId())
                .build();
        FolderEntity folderEntity = FolderMapper.toFolderEntity(folder);
        folderEntity.setUserEntity(userEntity);

        if (folderEntity.getParentFolder().getId() == null) {
            folderEntity.setParentFolder(null);
        }

        return FolderMapper.toFolder(folderRepository.save(folderEntity));
    }

    public List<Folder> getAll() {
        UserEntity userEntity = UserEntity.UserEntityBuilder.create()
                .withUsername(userService.getCurrentUserId())
                .build();
        return FolderMapper.toFolderList(folderRepository.findAllByUserEntity(userEntity));
    }

    public List<Folder> getTree() {
        List<FolderEntity> folderEntities = folderRepository.findAllByParentFolder(null);
        return FolderMapper.toFolderList(folderEntities);
    }

    public Folder getOne(String id) {
        if (folderRepository.existsById(id)) {
            return FolderMapper.toFolder(folderRepository.getOne(id));
        } else {
            throw new NotFoundException(("l'id du folder n'existe pas"));
        }
    }
}
