package fr.univparis8.iut.csid.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("files")
public class FileController {

    @Autowired
    private FileService fileService;

    private MimeTypes mimeTypes;

    @PostMapping
    public List<FileDto> uploadFiles(@RequestBody FileReceiveDto[] filesReceiveDto) throws IOException {
        ArrayList<FileDto> response = new ArrayList<>();
        for(FileReceiveDto file : filesReceiveDto){
                response.add(FileMapper.toFileDto(fileService.saveFile(FileMapper.toFile(file))));
       }
        return response;
    }

    @GetMapping()
    public List<FileDto> getAllFiles() {
        return FileMapper.toFileDtoList(fileService.getAll());
    }

    @GetMapping("/get_one")
    public FileDto getOneFile(@RequestBody FileDto fileDto){
        return FileMapper.toFileDto(fileService.getFile(fileDto.getId()));
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {

        File file = fileService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeTypes.getMimeType(file.getType())))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(new ByteArrayResource(file.getFileContent().getFileContent()));
    }

    @PatchMapping
    public FileDto updateFile(@RequestBody FileDto fileDto){
        return FileMapper.toFileDto(fileService.update(FileMapper.toFile(fileDto)));
    }

    @DeleteMapping("/{fileId}")
    public FileDto deleteFile(@PathVariable String fileId){
        return FileMapper.toFileDto(fileService.delete(fileId));
    }
}
