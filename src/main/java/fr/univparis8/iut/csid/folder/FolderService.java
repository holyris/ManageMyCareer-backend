package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.file.File;
import fr.univparis8.iut.csid.file.FileService;
import fr.univparis8.iut.csid.user.UserEntity;
import fr.univparis8.iut.csid.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    private final FolderRepository folderRepository;
    private final UserService userService;
    private final FileService fileService;

    public FolderService(FolderRepository folderRepository, UserService userService, FileService fileService) {
        this.folderRepository = folderRepository;
        this.userService = userService;
        this.fileService = fileService;
    }

    public List<Folder> findAll() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FolderMapper.toFolderList(folderRepository.findAllByUserEntity(userEntity));
    }

    public List<FolderWithChildren> getTree() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        List<FolderEntity> folderEntities = folderRepository.findAllByUserEntityAndParentFolder(userEntity, null);
        return FolderMapper.toFolderWithChildrenList(folderEntities);
    }

    public Folder getById(String folderId) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FolderMapper.toFolder(folderRepository.getByIdAndUserEntity(folderId, userEntity));
    }

    public List<File> findAllFilesById(String folderId) {
        return this.fileService.findAllByFolderEntity(this.getById(folderId));
    }

    public Folder save(Folder folder) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        FolderEntity folderEntity = FolderMapper.toFolderEntity(folder);
        folderEntity.setUserEntity(userEntity);

        return FolderMapper.toFolder(folderRepository.save(folderEntity));
    }

    public Folder update(Folder folder) {

        if (folder.getParentFolder() != null) {
            if (folder.getId().equals(folder.getParentFolder().getId())) {
                throw new IllegalArgumentException("A folder can't be a direct child of himself");
            }

            if (this.isChildOf(folder.getParentFolder().getId(), folder.getId())) {
                throw new IllegalArgumentException("A folder can't be a child of himself");
            }
        }

        Folder currentFolder = this.getById(folder.getId());
        FolderEntity newFolderEntity = FolderMapper.toFolderEntity(currentFolder.mergeWith(folder));

        UserEntity userEntity = userService.getCurrentUserEntity();
        newFolderEntity.setUserEntity(userEntity);
        return FolderMapper.toFolder(folderRepository.save(newFolderEntity));
    }

    public void delete(String folderId) {
        folderRepository.deleteById(folderId);
    }

    //return true if parentId is a parent of childId
    public boolean isChildOf(String childId, String parentId) {
        if (childId.equals(parentId)) {
            return true;
        } else {
            FolderEntity childFolderEntity = FolderMapper.toFolderEntity(this.getById(childId));
            if (childFolderEntity.getParentFolder() != null) {
                return isChildOf(childFolderEntity.getParentFolder().getId(), parentId);
            }
            return false;
        }
    }
}

