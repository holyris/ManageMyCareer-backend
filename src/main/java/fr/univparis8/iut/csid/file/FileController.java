package fr.univparis8.iut.csid.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("files")
public class FileController {

    @Autowired
    private FileService fileService;

    private MimeTypes mimeTypes;

    @PostMapping
    public List<FileResponseDto> uploadFiles(@RequestBody FileReceiveDto[] filesReceiveDto){
        ArrayList<FileResponseDto> response = new ArrayList<>();
        for(FileReceiveDto file : filesReceiveDto){
            FileResponseDto fileDto = FileMapper.toFileDto(fileService.save(FileMapper.toFile(file)));
            response.add(fileDto);
        }
        return response;
    }

    @GetMapping()
    public List<FileResponseDto> getAllFiles() {
        return FileMapper.toFileDtoList(fileService.getAll());
    }

    @GetMapping("/get_one")
    public FileResponseDto getOneFile(@RequestBody FileResponseDto fileResponseDto){
        return FileMapper.toFileDto(fileService.getOne(fileResponseDto.getId()));
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {

        File file = fileService.getOne(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(new ByteArrayResource(file.getFileContent().getFileContent()));
    }
    @GetMapping("/companies")
    public List<String> getCompanies(){
        return fileService.getCompanies();
    }
    @GetMapping("/workplaces")
    public List<String> getWorkplaces(){
        return fileService.getWorkplaces();
    }

    @PatchMapping
    public FileResponseDto updateFile(@RequestBody FileReceiveDto fileReceiveDto){
        fileReceiveDto.setModifiedDate(new Date());
        return FileMapper.toFileDto(fileService.update(FileMapper.toFile(fileReceiveDto)));
    }

    @DeleteMapping("/{fileId}")
    public FileResponseDto deleteFile(@PathVariable String fileId){
        return FileMapper.toFileDto(fileService.delete(fileId));
    }
}
