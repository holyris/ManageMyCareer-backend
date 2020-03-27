package fr.univparis8.iut.csid.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fileName;

    private String fileType;

    private Long fileSize;


    @Lob
    private byte[] data;

    public FileEntity(){

    }

    public FileEntity(String fileName, String fileType, Long fileSize, byte[] data){
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.fileSize = fileSize;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public byte[] getData() {
        return data;
    }

    public Long getFileSize() {return fileSize; }

}
