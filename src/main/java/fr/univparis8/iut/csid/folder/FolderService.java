package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.exception.NotFoundException;
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

    public Folder findById(String folderId) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FolderMapper.toFolder(folderRepository.findByIdAndUserEntity(folderId, userEntity)
                .orElseThrow(() -> new NotFoundException("Folder not found with id " + folderId + " for user " + userEntity.getUsername())));
    }

    public List<File> findAllFilesById(String folderId) {
        return this.fileService.findAllByFolderEntity(this.findById(folderId));
    }

    public Folder save(Folder folder) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        FolderEntity folderEntity = FolderMapper.toFolderEntity(folder);
        folderEntity.setUserEntity(userEntity);

        return FolderMapper.toFolder(folderRepository.save(folderEntity));
    }

    public Folder update(Folder folder) {
        if (folder.getId() == null) {
            throw new NotFoundException("Id is null");
        }
        if (!folderRepository.existsById(folder.getId())) {
            throw new NotFoundException("Folder not found with id " + folder.getId());
        }

        if (folder.getParentFolder() != null) {
            if (folder.getId().equals(folder.getParentFolder().getId())) {
                throw new IllegalArgumentException("A folder can't be a direct child of himself");
            }

            if (this.isChildOf(folder.getParentFolder().getId(), folder.getId())) {
                throw new IllegalArgumentException("A folder can't be a child of himself");
            }
        }

        Folder currentFolder = this.findById(folder.getId());
        FolderEntity newFolderEntity = FolderMapper.toFolderEntity(currentFolder.mergeWith(folder));

        UserEntity userEntity = userService.getCurrentUserEntity();
        newFolderEntity.setUserEntity(userEntity);
        return FolderMapper.toFolder(folderRepository.save(newFolderEntity));
    }

    public Folder delete(String folderId) {
        if (folderRepository.existsById(folderId)) {
            Folder folder = this.findById(folderId);
            folderRepository.deleteById(folder.getId());
            return folder;
        } else {
            throw new NotFoundException("Folder not found with id " + folderId);
        }

    }

    //return true if parentId is a parent of childId
    public boolean isChildOf(String childId, String parentId) {
        if (childId.equals(parentId)) {
            return true;
        } else {
            FolderEntity childFolderEntity = FolderMapper.toFolderEntity(this.findById(childId));
            if (childFolderEntity.getParentFolder() != null) {
                return isChildOf(childFolderEntity.getParentFolder().getId(), parentId);
            }
            return false;
        }
    }
}

