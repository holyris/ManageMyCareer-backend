package fr.univparis8.iut.csid.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("files")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        FileEntity dbFile = fileService.saveFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                dbFile.getFileType(), dbFile.getFileSize());
    }

    @PostMapping("/multiples")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping()
    public List<UploadFileResponse> getAllFiles() {
        // Load file from database

        List<FileEntity> dbFiles = fileService.getAll();
        List<UploadFileResponse> responses = new ArrayList<UploadFileResponse>();
        for (FileEntity file : dbFiles) {
            String downloadUrl = "http://localhost:8080/"+file.getId();
            responses.add(new UploadFileResponse(file.getFileName(), downloadUrl, file.getFileType(), file.getFileSize()));
        }
        return responses;
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        FileEntity dbFile = fileService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

}
