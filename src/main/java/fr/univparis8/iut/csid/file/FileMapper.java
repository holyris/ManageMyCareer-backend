package fr.univparis8.iut.csid.file;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public final class FileMapper {

    public static File toFile(FileEntity fileEntity){
        return File.FileBuilder.create()
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
                .build();
    }

    public static FileResponseDto toFileDto(File file){
        return FileResponseDto.FileResponseDtoBuilder.create()
                .withId(file.getId())
                .withName(file.getName())
                .withType(file.getType())
                .withDocumentType(file.getDocumentType())
                .withSize(file.getSize())
                .withDocumentDate(file.getDocumentDate())
                .withAddedDate(file.getAddedDate())
                .withModifiedDate(file.getModifiedDate())
                .withCompany(file.getCompany())
                .withWorkplace(file.getWorkplace())
                .withGrossSalary(file.getGrossSalary())
                .withNetSalary(file.getNetSalary())
                .build();
    }

    public static FileEntity toFileEntity(File file){

        return FileEntity.FileEntityBuilder.create()
                .withId(file.getId())
                .withName(file.getName())
                .withType(file.getType())
                .withDocumentType(file.getDocumentType())
                .withSize(file.getSize())
                .withData(file.getFileContent())
                .withDocumentDate(file.getDocumentDate())
                .withAddedDate(file.getAddedDate())
                .withModifiedDate(file.getModifiedDate())
                .withCompany(file.getCompany())
                .withWorkplace(file.getWorkplace())
                .withGrossSalary(file.getGrossSalary())
                .withNetSalary(file.getNetSalary())
                .build();
    }

    public static File toFile(FileReceiveDto fileReceiveDto) throws IOException {
        FileContentEntity fileContentEntity = new FileContentEntity();
        fileContentEntity.setFileContent(fileReceiveDto.getFileContent());

        return File.FileBuilder.create()
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
                .build();
    }

    public static List<File> toFilesList(List<FileEntity> fileEntities) {
        return fileEntities.stream()
                .map(FileMapper::toFile)
                .collect(Collectors.toList());
    }

    public static List<FileResponseDto> toFileDtoList(List<File> files) {
        return files.stream()
                .map(FileMapper::toFileDto)
                .collect(Collectors.toList());
    }





}
