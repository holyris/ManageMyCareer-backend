package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.folder.FolderModel;
import fr.univparis8.iut.csid.folder.FolderEntity;
import fr.univparis8.iut.csid.folder.FolderMapper;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public final class FileMapper {

    public static FileModel toFile(FileEntity fileEntity) {
        FolderModel folderModel = FolderMapper.toFolder(fileEntity.getFolderEntity());
        return FileModel.FileBuilder.create()
                .withId(fileEntity.getId())
                .withName(fileEntity.getName())
                .withType(fileEntity.getType())
                .withDocumentType(fileEntity.getDocumentType())
                .withSize(fileEntity.getSize())
                .withFileContent(fileEntity.getFileContent())
                .withDocumentDate(fileEntity.getDocumentDate())
                .withAddedDate(fileEntity.getAddedDate())
                .withModifiedDate(fileEntity.getModifiedDate())
                .withCompany(fileEntity.getCompany())
                .withWorkplace(fileEntity.getWorkplace())
                .withGrossSalary(fileEntity.getGrossSalary())
                .withNetSalary(fileEntity.getNetSalary())
                .withFolder(folderModel)
                .build();
    }

    public static FileResponseDto toFileDto(FileModel fileModel) {

        String folderId = null;
        String documentMonth = null;
        String documentYear = null;
        if (fileModel.getFolderModel() != null) {
            folderId = fileModel.getFolderModel().getId();
        }
        if(fileModel.getDocumentDate() != null){
            documentMonth = new SimpleDateFormat("MMMM").format(fileModel.getDocumentDate());
            documentYear = new SimpleDateFormat("y").format(fileModel.getDocumentDate());
        }


        return FileResponseDto.FileResponseDtoBuilder.create()
                .withId(fileModel.getId())
                .withName(fileModel.getName())
                .withType(fileModel.getType())
                .withDocumentType(fileModel.getDocumentType())
                .withSize(fileModel.getSize())
                .withDocumentDate(fileModel.getDocumentDate())
                .withDocumentMonth(documentMonth)
                .withDocumentYear(documentYear)
                .withAddedDate(fileModel.getAddedDate())
                .withModifiedDate(fileModel.getModifiedDate())
                .withCompany(fileModel.getCompany())
                .withWorkplace(fileModel.getWorkplace())
                .withGrossSalary(fileModel.getGrossSalary())
                .withNetSalary(fileModel.getNetSalary())
                .withFolderId(folderId)
                .build();
    }

    public static FileEntity toFileEntity(FileModel fileModel) {
        FolderEntity folderEntity = FolderMapper.toFolderEntity(fileModel.getFolderModel());
        return FileEntity.FileEntityBuilder.create()
                .withId(fileModel.getId())
                .withName(fileModel.getName())
                .withType(fileModel.getType())
                .withDocumentType(fileModel.getDocumentType())
                .withSize(fileModel.getSize())
                .withData(fileModel.getFileContent())
                .withDocumentDate(fileModel.getDocumentDate())
                .withAddedDate(fileModel.getAddedDate())
                .withModifiedDate(fileModel.getModifiedDate())
                .withCompany(fileModel.getCompany())
                .withWorkplace(fileModel.getWorkplace())
                .withGrossSalary(fileModel.getGrossSalary())
                .withNetSalary(fileModel.getNetSalary())
                .withFolderEntity(folderEntity)
                .build();
    }

    public static FileModel toFile(FileReceiveDto fileReceiveDto) {
        FileContentEntity fileContentEntity = new FileContentEntity();
        fileContentEntity.setFileContent(fileReceiveDto.getFileContent());

        FolderModel folderModel = null;
        if (fileReceiveDto.getFolderId() != null) {
            folderModel = FolderModel.FolderBuilder.create()
                    .withId(fileReceiveDto.getFolderId())
                    .build();
        }

        return FileModel.FileBuilder.create()
                .withId(fileReceiveDto.getId())
                .withName(fileReceiveDto.getName())
                .withType(fileReceiveDto.getType())
                .withDocumentType(fileReceiveDto.getDocumentType())
                .withSize(fileReceiveDto.getSize())
                .withFileContent(fileContentEntity)
                .withDocumentDate(fileReceiveDto.getDocumentDate())
                .withAddedDate(fileReceiveDto.getAddedDate())
                .withModifiedDate(fileReceiveDto.getModifiedDate())
                .withCompany(fileReceiveDto.getCompany())
                .withWorkplace(fileReceiveDto.getWorkplace())
                .withGrossSalary(fileReceiveDto.getGrossSalary())
                .withNetSalary(fileReceiveDto.getNetSalary())
                .withFolder(folderModel)
                .build();
    }

    public static List<FileModel> FileEntityListToFileList(List<FileEntity> fileEntities) {
        return fileEntities.stream()
                .map(FileMapper::toFile)
                .collect(Collectors.toList());
    }

    public static List<FileModel> FileDtoListToFileList(List<FileReceiveDto> fileReceiveDtos) {
        return fileReceiveDtos.stream()
                .map(FileMapper::toFile)
                .collect(Collectors.toList());
    }

    public static List<FileResponseDto> toFileDtoList(List<FileModel> fileModels) {
        return fileModels.stream()
                .map(FileMapper::toFileDto)
                .collect(Collectors.toList());
    }

    public static List<FileEntity> toFileEntityList(List<FileModel> fileModels) {
        return fileModels.stream()
                .map(FileMapper::toFileEntity)
                .collect(Collectors.toList());
    }


}
