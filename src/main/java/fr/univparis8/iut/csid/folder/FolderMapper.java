package fr.univparis8.iut.csid.folder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FolderMapper {

    public static FolderModel toFolderModel(FolderDto folderDto) {
        if (folderDto == null) return null;

        FolderModel parentFolderModel = null;
        if (folderDto.getParentFolderId() != null) {
            parentFolderModel = FolderModel.FolderBuilder.create()
                    .withId(folderDto.getParentFolderId())
                    .build();
        }

        return FolderModel.FolderBuilder.create()
                .withId(folderDto.getId())
                .withName(folderDto.getName())
                .withParentFolder(parentFolderModel)
                .build();
    }

    public static FolderModel toFolderModel(FolderEntity folderEntity) {
        if (folderEntity == null) return null;
        FolderModel parentFolderModel = FolderMapper.toFolderModel(folderEntity.getParentFolder());
        return FolderModel.FolderBuilder.create()
                .withId(folderEntity.getId())
                .withName(folderEntity.getName())
                .withParentFolder(parentFolderModel)
                .build();
    }

    public static FolderEntity toFolderEntity(FolderModel folderModel) {
        if (folderModel == null) return null;

        FolderEntity parentFolderEntity = FolderMapper.toFolderEntity(folderModel.getParentFolderModel());
        return FolderEntity.FolderEntityBuilder.create()
                .withId(folderModel.getId())
                .withName(folderModel.getName())
                .withParentFolder(parentFolderEntity)
                .build();
    }

    public static FolderDto toFolderDto(FolderModel folderModel) {
        if (folderModel == null) return null;

        String parentFolderId = null;
        if (folderModel.getParentFolderModel() != null) {
            parentFolderId = folderModel.getParentFolderModel().getId();
        }
        return FolderDto.FolderDtoBuilder.create()
                .withId(folderModel.getId())
                .withName(folderModel.getName())
                .withParentFolderId(parentFolderId)
                .build();
    }


    public static FolderWithChildrenModel toFolderWithChildrenModel(FolderEntity folderEntity) {
        if (folderEntity == null) return null;

        List<FolderEntity> folderEntities = new ArrayList<>(folderEntity.getChildFolders());
        List<FolderWithChildrenModel> childFolders = FolderMapper.toFolderWithChildrenModelList(folderEntities);

        return FolderWithChildrenModel.FolderWithChildrenBuilder.create()
                .withId(folderEntity.getId())
                .withName(folderEntity.getName())
                .withChildFolders(childFolders)
                .build();
    }

    public static FolderWithChildrenDto toFolderWithChildrenDto(FolderWithChildrenModel folderWithChildrenModel) {
        if (folderWithChildrenModel == null) return null;

        List<FolderWithChildrenDto> childFolders = FolderMapper.toFolderWithChildrenDtoList(folderWithChildrenModel.getChildFolders());
        return FolderWithChildrenDto.FolderWithChildrenDtoBuilder.create()
                .withId(folderWithChildrenModel.getId())
                .withName(folderWithChildrenModel.getName())
                .withChildFolders(childFolders)
                .build();
    }

    public static List<FolderModel> toFolderModelList(List<FolderEntity> folderEntities) {
        return folderEntities.stream()
                .map(FolderMapper::toFolderModel)
                .collect(Collectors.toList());
    }

    public static List<FolderDto> toFolderDtoList(List<FolderModel> folderModels) {
        return folderModels.stream()
                .map(FolderMapper::toFolderDto)
                .collect(Collectors.toList());
    }

    public static List<FolderWithChildrenModel> toFolderWithChildrenModelList(List<FolderEntity> folderEntities) {
        return folderEntities.stream()
                .map(FolderMapper::toFolderWithChildrenModel)
                .collect(Collectors.toList());
    }

    public static List<FolderWithChildrenDto> toFolderWithChildrenDtoList(List<FolderWithChildrenModel> foldersWithChildren) {
        return foldersWithChildren.stream()
                .map(FolderMapper::toFolderWithChildrenDto)
                .collect(Collectors.toList());
    }

}
