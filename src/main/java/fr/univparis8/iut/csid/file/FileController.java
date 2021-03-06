package fr.univparis8.iut.csid.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public List<FileResponseDto> uploadFiles(@RequestBody List<FileReceiveDto> fileReceiveDtos) {
        List<FileModel> fileModelList = FileMapper.FileDtoListToFileModelList(fileReceiveDtos);
        return FileMapper.toFileDtoList(fileService.saveAll(fileModelList));
    }

    @GetMapping()
    public List<FileResponseDto> getAllFiles() {
        return FileMapper.toFileDtoList(fileService.findAll());
    }

    @GetMapping("/get_one")
    public FileResponseDto getOneFile(@RequestBody FileResponseDto fileResponseDto){
        return FileMapper.toFileDto(fileService.getById(fileResponseDto.getId()));
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {

        FileModel fileModel = fileService.getById(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileModel.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileModel.getName() + "\"")
                .body(new ByteArrayResource(fileModel.getFileContent().getFileContent()));
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
        return FileMapper.toFileDto(fileService.update(FileMapper.toFileModel(fileReceiveDto)));
    }

    @DeleteMapping
    public void deleteFile(@RequestBody List<FileReceiveDto> fileReceiveDtos) {
        List<FileModel> fileModelList = FileMapper.FileDtoListToFileModelList(fileReceiveDtos);
        fileService.deleteInBatch(fileModelList);
    }
}
