package fr.univparis8.iut.csid.folder;

import java.util.List;
import java.util.stream.Collectors;

public class FolderMapper {

    public static Folder toFolder(FolderDto folderDto){
        if(folderDto.getFolderId() != null){
            Folder folder = Folder.FolderBuilder.create()
                    .withId(folderDto.getFolderId())
                    .build();
            return Folder.FolderBuilder.create()
                    .withId(folderDto.getId())
                    .withName(folderDto.getName())
                    .withFolder(folder)
                    .build();
        }else{
            return Folder.FolderBuilder.create()
                    .withId(folderDto.getId())
                    .withName(folderDto.getName())
                    .build();

        }

    }

    public static Folder toFolder(FolderEntity folderEntity){
        if(folderEntity.getParentFolder() != null){
            Folder folder = FolderMapper.toFolder(folderEntity.getParentFolder());
            return Folder.FolderBuilder.create()
                    .withId(folderEntity.getId())
                    .withName(folderEntity.getName())
                    .withFolder(folder)
                    .build();
       }else{
            return Folder.FolderBuilder.create()
                    .withId(folderEntity.getId())
                    .withName(folderEntity.getName())
                    .build();

        }

    }

    public static FolderEntity toFolderEntity(Folder folder){
        if(folder.getFolder() != null){
            FolderEntity folderEntity = FolderEntity.FolderEntityBuilder.create()
                    .withId(folder.getFolder().getId())
                    .build();
            return FolderEntity.FolderEntityBuilder.create()
                    .withId(folder.getId())
                    .withName(folder.getName())
                    .withParentFolder(folderEntity)
                    .build();
        }else{
            return FolderEntity.FolderEntityBuilder.create()
                    .withId(folder.getId())
                    .withName(folder.getName())
                    .build();
        }

    }

    public static FolderDto toFolderDto(Folder folder){
        if(folder.getFolder() != null){
            return FolderDto.FolderDtoBuilder.create()
                    .withId(folder.getId())
                    .withName(folder.getName())
                    .withFolderId(folder.getFolder().getId())
                    .build();
        }else{
            return FolderDto.FolderDtoBuilder.create()
                    .withId(folder.getId())
                    .withName(folder.getName())
                    .build();
        }

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
