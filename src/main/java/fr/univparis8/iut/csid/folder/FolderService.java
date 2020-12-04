package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.file.FileModel;
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

    public List<FolderModel> findAll() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FolderMapper.toFolderModelList(folderRepository.findAllByUserEntity(userEntity));
    }

    public List<FolderWithChildrenModel> getTree() {
        UserEntity userEntity = userService.getCurrentUserEntity();
        List<FolderEntity> folderEntities = folderRepository.findAllByUserEntityAndParentFolder(userEntity, null);
        return FolderMapper.toFolderWithChildrenModelList(folderEntities);
    }

    public FolderModel getById(String folderId) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        return FolderMapper.toFolderModel(folderRepository.getByIdAndUserEntity(folderId, userEntity));
    }

    public List<FileModel> findAllFilesById(String folderId) {
        return this.fileService.findAllByFolderEntity(this.getById(folderId));
    }

    public FolderModel save(FolderModel folderModel) {
        UserEntity userEntity = userService.getCurrentUserEntity();
        FolderEntity folderEntity = FolderMapper.toFolderEntity(folderModel);
        folderEntity.setUserEntity(userEntity);

        return FolderMapper.toFolderModel(folderRepository.save(folderEntity));
    }

    public FolderModel update(FolderModel folderModel) {

        if (folderModel.getParentFolderModel() != null) {
            if (folderModel.getId().equals(folderModel.getParentFolderModel().getId())) {
                throw new IllegalArgumentException("A folder can't be a direct child of himself");
            }

            if (this.isChildOf(folderModel.getParentFolderModel().getId(), folderModel.getId())) {
                throw new IllegalArgumentException("A folder can't be a child of himself");
            }
        }

        FolderModel currentFolderModel = this.getById(folderModel.getId());
        FolderEntity newFolderEntity = FolderMapper.toFolderEntity(currentFolderModel.mergeWith(folderModel));

        UserEntity userEntity = userService.getCurrentUserEntity();
        newFolderEntity.setUserEntity(userEntity);
        return FolderMapper.toFolderModel(folderRepository.save(newFolderEntity));
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

