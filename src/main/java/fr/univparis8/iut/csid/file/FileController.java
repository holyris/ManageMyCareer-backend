package fr.univparis8.iut.csid.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
    public List<FileResponseDto> uploadFiles(@RequestBody List<FileReceiveDto> filesReceiveDto){
        fileService.save(FileMapper.DtotoFileList(filesReceiveDto));
        return FileMapper.toFileDtoList(fileService.save(FileMapper.DtotoFileList(filesReceiveDto)));
    }

    @GetMapping()
    public List<FileResponseDto> getAllFiles() {
        return FileMapper.toFileDtoList(fileService.findAll());
    }

    @GetMapping("/get_one")
    public FileResponseDto getOneFile(@RequestBody FileResponseDto fileResponseDto){
        return FileMapper.toFileDto(fileService.findById(fileResponseDto.getId()));
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {

        File file = fileService.findById(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(new ByteArrayResource(file.getFileContent().getFileContent()));
    }
    @GetMapping("/companies")
    public List<String> getCompanies(){
        return fileService.findAllCompanies();
    }
    @GetMapping("/workplaces")
    public List<String> getWorkplaces(){
        return fileService.findAllWorkplaces();
    }

    @PatchMapping
    public FileResponseDto updateFile(@RequestBody FileReceiveDto fileReceiveDto){
        fileReceiveDto.setModifiedDate(new Date());
        return FileMapper.toFileDto(fileService.update(FileMapper.toFile(fileReceiveDto)));
    }

    @DeleteMapping
    public void deleteFile(@RequestBody String[] fileIds) throws SQLException {
        fileService.delete(fileIds);
    }
}
