package fr.univparis8.iut.csid.file;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "file_content")
public class FileContentEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne(mappedBy = "fileContent")
    private FileEntity file;

    @Lob
    private byte[] fileContent;

    public FileContentEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public FileEntity getFileEntity() {
        return file;
    }

    public void setFileEntity(FileEntity file) {
        this.file = file;
    }
}
