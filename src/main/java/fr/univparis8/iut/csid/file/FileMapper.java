package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.user.User;
import fr.univparis8.iut.csid.user.UserEntity;

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
                .withDateOfDoc(fileEntity.getDateOfDoc())
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
                .withDateOfDoc(file.getDateOfDoc())
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
                .withDateOfDoc(file.getDateOfDoc())
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
                .withDateOfDoc(fileReceiveDto.getDateOfDoc())
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
