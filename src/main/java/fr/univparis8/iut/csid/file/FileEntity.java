package fr.univparis8.iut.csid.file;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String type;
    private Long size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_content_id", referencedColumnName = "id")
    private FileContentEntity fileContent;

    public FileEntity(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public FileContentEntity getFileContent() {
        return fileContent;
    }

    public void setFileContent(FileContentEntity fileContent) {
        this.fileContent = fileContent;
    }

    public static final class FileEntityBuilder {
        private String id;
        private String name;
        private String type;
        private Long size;
        private FileContentEntity fileContent;

        public FileEntityBuilder() {
        }

        public static FileEntityBuilder create(){return new FileEntityBuilder();}

        public FileEntityBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FileEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FileEntityBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileEntityBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileEntityBuilder withData(FileContentEntity fileContentEntity) {
            this.fileContent = fileContentEntity;
            return this;
        }

        public FileEntity build() {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setId(id);
            fileEntity.setName(name);
            fileEntity.setType(type);
            fileEntity.setSize(size);
            fileEntity.setFileContent(fileContent);
            return fileEntity;
        }


    }

}
