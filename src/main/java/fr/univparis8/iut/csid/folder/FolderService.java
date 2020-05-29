package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    private final FolderRepository folderRepository;

    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public Folder save(Folder folder){
        return FolderMapper.toFolder(folderRepository.save(FolderMapper.toFolderEntity(folder)));
    }

    public List<Folder> getAll(){
        return FolderMapper.toFolderList(folderRepository.findAll());
    }

    public Folder getOne(String id){
        if(isExist(id)){
            return FolderMapper.toFolder(folderRepository.getOne(id));
        }else{
             throw new NotFoundException(("l'id du folder n'existe pas"));
        }
    }

    public Boolean isExist(String id){
        if(folderRepository.existsById(id)){
            return true;
        }else{
            return false;
        }
    }
}
