package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.file.FileEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "folder")
public class FolderEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;

    @OneToMany(mappedBy = "folderEntity", cascade = CascadeType.ALL)
    private Set<FileEntity> fileEntities;

    @ManyToOne(cascade = CascadeType.MERGE)
    @Nullable
    private FolderEntity folderEntity;

    public FolderEntity() {

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

    public Set<FileEntity> getFileEntities() {
        return fileEntities;
    }

    public void setFileEntities(Set<FileEntity> fileEntities) {
        this.fileEntities = fileEntities;
    }

    public FolderEntity getFolderEntity() {
        return folderEntity;
    }

    public void setFolderEntity(FolderEntity folderEntity) {
        this.folderEntity = folderEntity;
    }

/*
    public Set<FolderEntity> getFolderEntities() {
        return folderEntities;
    }

    public void setFolderEntities(Set<FolderEntity> folderEntities) {
        this.folderEntities = folderEntities;
    }
*/


    public static final class FolderEntityBuilder {
        private String id;
        private String name;
        private Set<FileEntity> fileEntities;
        private FolderEntity folderEntity;
//        private Set<FolderEntity> folderEntities;

        private FolderEntityBuilder() {
        }

        public static FolderEntityBuilder create() {
            return new FolderEntityBuilder();
        }

        public FolderEntityBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FolderEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FolderEntityBuilder withFileEntities(Set<FileEntity> fileEntities) {
            this.fileEntities = fileEntities;
            return this;
        }

        public FolderEntityBuilder withFolderEntity(FolderEntity folderEntity) {
            this.folderEntity = folderEntity;
            return this;
        }
/*
        public FolderEntityBuilder withFolderEntities(Set<FolderEntity> folderEntities) {
            this.folderEntities = folderEntities;
            return this;
        }*/

        public FolderEntity build() {
            FolderEntity folderEntity1 = new FolderEntity();
            folderEntity1.setId(id);
            folderEntity1.setName(name);
            folderEntity1.setFileEntities(fileEntities);
            folderEntity1.setFolderEntity(folderEntity);
//            folderEntity1.setFolderEntities(folderEntities);
            return folderEntity1;
        }
    }
}
