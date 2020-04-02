package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.exception.MyFileNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File saveFile(File file) {
        return FileMapper.toFile(fileRepository.save(FileMapper.toFileEntity(file)));
    }

    public List<File> getAll() {
        return  FileMapper.toFilesList(fileRepository.findAll());
    }

    public File getFile(String fileId) {
        return FileMapper.toFile(fileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId)));
    }

    public File update(File file) {
        if (!fileRepository.existsById(file.getId())) {
            throw new MyFileNotFoundException("File not found with id " + file.getId());
        }

        File currentFile = FileMapper.toFile(fileRepository.getOne(file.getId()));
        File newFile = currentFile.mergeWith(file);

        return FileMapper.toFile(fileRepository.save(FileMapper.toFileEntity(newFile)));
    }

    public File delete(String fileId){
        File file = FileMapper.toFile(fileRepository.getOne(fileId));
        if(file != null) {
            fileRepository.deleteById(file.getId());
        }
        return file;
    }
}
