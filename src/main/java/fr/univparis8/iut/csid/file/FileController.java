package fr.univparis8.iut.csid.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {

    private final FileService fileService;
    @Autowired
    public FileController(FileService fileService){this.fileService = fileService;}

    @PostMapping
    public List<FileDto> uploadFiles(@RequestBody List<FileDto> fileDto) {
        List<FileDto> responses = new ArrayList<FileDto>();
        for(FileDto filesDto : fileDto){
            responses.add(FileMapper.toFileDto(fileService.saveFile(FileMapper.toFile(filesDto))));
        }
        return responses;
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
                .contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(new ByteArrayResource(file.getData()));
    }

    @PutMapping
    public FileDto updateFile(@RequestBody FileDto fileDto){
        return FileMapper.toFileDto(fileService.update(FileMapper.toFile(fileDto)));
    }

    @DeleteMapping
    public String deleteFile(@RequestBody FileDto fileDto){
        return "Le fichier "+fileService.delete(FileMapper.toFile(fileDto)).getName()+" a bien été supprimé";
    }
}
