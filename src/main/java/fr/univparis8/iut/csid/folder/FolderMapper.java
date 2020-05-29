package fr.univparis8.iut.csid.folder;

import java.util.List;
import java.util.stream.Collectors;

public class FolderMapper {

    public static Folder toFolder(FolderDto folderDto) {
        if (folderDto == null) return null;
        Folder parentFolder = Folder.FolderBuilder.create()
                .withId(folderDto.getParentFolderId())
                .build();
        return Folder.FolderBuilder.create()
                .withId(folderDto.getId())
                .withName(folderDto.getName())
                .withParentFolder(parentFolder)
                .build();
    }

    public static Folder toFolder(FolderEntity folderEntity) {
        if (folderEntity == null) return null;
        Folder parentFolder = FolderMapper.toFolder(folderEntity.getParentFolder());
        return Folder.FolderBuilder.create()
                .withId(folderEntity.getId())
                .withName(folderEntity.getName())
                .withParentFolder(parentFolder)
                .build();
    }

    public static FolderEntity toFolderEntity(Folder folder) {
        if (folder == null) return null;

        FolderEntity parentFolderEntity = FolderMapper.toFolderEntity(folder.getParentFolder());
        return FolderEntity.FolderEntityBuilder.create()
                .withId(folder.getId())
                .withName(folder.getName())
                .withParentFolder(parentFolderEntity)
                .build();
    }

    public static FolderDto toFolderDto(Folder folder) {
        if (folder == null) return null;

        String parentFolderId = null;
        if(folder.getParentFolder() != null) {
            parentFolderId = folder.getParentFolder().getId();
        }
        return FolderDto.FolderDtoBuilder.create()
                .withId(folder.getId())
                .withName(folder.getName())
                .withParentFolderId(parentFolderId)
                .build();
    }

    public static List<Folder> toFolderList(List<FolderEntity> folderEntities) {
        return folderEntities.stream()
                .map(FolderMapper::toFolder)
                .collect(Collectors.toList());
    }

    public static List<FolderDto> toFolderDtoList(List<Folder> folders) {
        return folders.stream()
                .map(FolderMapper::toFolderDto)
                .collect(Collectors.toList());
    }


}
