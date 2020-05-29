package fr.univparis8.iut.csid.folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("folders")
public class FolderController {

    @Autowired
    FolderService folderService;

    @PostMapping
    public FolderDto save(@RequestBody FolderDto folderDto){
        return FolderMapper.toFolderDto(folderService.save(FolderMapper.toFolder(folderDto)));
    }

    @GetMapping
    public List<FolderDto> get(){
        return  FolderMapper.toFolderDtoList(folderService.getAll());
    }
}
