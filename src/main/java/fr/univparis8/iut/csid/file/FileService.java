package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.exception.FileStorageException;
import fr.univparis8.iut.csid.exception.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public FileEntity saveFile(MultipartFile file) {

        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (filename.contains("..")) {
                /* throw new FileStorageException("Sorry! Filename contains invalid path sequence " + filename);*/
                System.out.println("erreur : le nom du fichier contient un caractère");
            }

            FileEntity dbFile = new FileEntity(filename, file.getContentType(), file.getSize(), file.getBytes());

            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + filename + ". Please try again!", ex);
        }

    }

    public List<FileEntity> getAll() {
        System.out.println(fileRepository.findAll());
        return  fileRepository.findAll();
    }

    public FileEntity getFile(String fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
