package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.file.FileMapper;
import fr.univparis8.iut.csid.file.FileReceiveDto;
import fr.univparis8.iut.csid.file.FileResponseDto;
import fr.univparis8.iut.csid.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("folders")
public class FolderController {

    @Autowired
    FolderService folderService;

    @GetMapping
    public List<FolderDto> getAll() {
        return FolderMapper.toFolderDtoList(folderService.getAll());
    }

    @GetMapping("/{folderId}")
    public FolderDto get(@PathVariable String folderId){
        return FolderMapper.toFolderDto(folderService.getOne(folderId));
    }

    @GetMapping("/tree")
    public List<FolderWithChildrenDto> getTree() {
        return FolderMapper.toFolderWithChildrenDtoList(folderService.getTree());
    }

    @GetMapping("/{folderId}/files")
    public List<FileResponseDto> getFilesByFolder(@PathVariable String folderId){
        return FileMapper.toFileDtoList(folderService.getFiles(folderId));
    }

    @PostMapping
    public FolderDto save(@RequestBody FolderDto folderDto) {
        return FolderMapper.toFolderDto(folderService.save(FolderMapper.toFolder(folderDto)));
    }

    @PatchMapping
    public FolderDto update(@RequestBody FolderDto folderDto){
        return FolderMapper.toFolderDto(folderService.update(FolderMapper.toFolder(folderDto)));
    }

    @DeleteMapping("/{folderId}")
    public FolderDto delete(@PathVariable String folderId){
        return FolderMapper.toFolderDto(folderService.delete(folderId));
    }
}
