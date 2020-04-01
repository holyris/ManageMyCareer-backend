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
                .withSize(fileDto.getSize())
                .build();
    }

    public static File toFile(FileEntity fileEntity){
        return File.FileBuilder.create()
                .withId(fileEntity.getId())
                .withName(fileEntity.getName())
                .withType(fileEntity.getType())
                .withSize(fileEntity.getSize())
                .withData(fileEntity.getData())
                .build();
    }

    public static FileDto toFileDto(File file){
        return FileDto.FileDtoBuilder.create()
                .withId(file.getId())
                .withName(file.getName())
                .withType(file.getType())
                .withSize(file.getSize())
                .build();
    }

    public static FileEntity toFileEntity(File file){
        return FileEntity.FileEntityBuilder.create()
                .withId(file.getId())
                .withName(file.getName())
                .withType(file.getType())
                .withSize(file.getSize())
                .withData(file.getData())
                .build();
    }

    public static File toFile(MultipartFile file) throws IOException {
        return File.FileBuilder.create()
                .withName(file.getOriginalFilename())
                .withType(file.getContentType())
                .withSize(file.getSize())
                .withData(file.getBytes())
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
