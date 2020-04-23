package fr.univparis8.iut.csid.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public final class FileMapper {

    public static File toFile(FileDto fileDto){
        return File.FileBuilder.create()
                .withId(fileDto.getId())
                .withName(fileDto.getName())
                .withType(fileDto.getType())
                .withTypeFile(fileDto.getTypeFile())
                .withSize(fileDto.getSize())
                .withDate(fileDto.getDate())
                .withCompany(fileDto.getCompany())
                .withWorkplace(fileDto.getWorkplace())
                .withGrossSalary(fileDto.getGrossSalary())
                .withNetSalary(fileDto.getNetSalary())
                .build();
    }

    public static File toFile(FileEntity fileEntity){
        return File.FileBuilder.create()
                .withId(fileEntity.getId())
                .withName(fileEntity.getName())
                .withType(fileEntity.getType())
                .withTypeFile(fileEntity.getTypeFile())
                .withSize(fileEntity.getSize())
                .withFileContent(fileEntity.getFileContent())
                .withDate(fileEntity.getDate())
                .withCompany(fileEntity.getCompany())
                .withWorkplace(fileEntity.getWorkplace())
                .withGrossSalary(fileEntity.getGrossSalary())
                .withNetSalary(fileEntity.getNetSalary())
                .build();
    }

    public static FileDto toFileDto(File file){
        return FileDto.FileDtoBuilder.create()
                .withId(file.getId())
                .withName(file.getName())
                .withType(file.getType())
                .withTypeFile(file.getTypeFile())
                .withSize(file.getSize())
                .withDate(file.getDate())
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
                .withTypeFile(file.getTypeFile())
                .withSize(file.getSize())
                .withData(file.getFileContent())
                .withDate(file.getDate())
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
                .withName(fileReceiveDto.getName())
                .withType(fileReceiveDto.getType())
                .withTypeFile(fileReceiveDto.getTypeFile())
                .withSize(fileReceiveDto.getSize())
                .withFileContent(fileContentEntity)
                .withDate(fileReceiveDto.getDate())
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

    public static List<FileDto> toFileDtoList(List<File> files) {
        return files.stream()
                .map(FileMapper::toFileDto)
                .collect(Collectors.toList());
    }





}
