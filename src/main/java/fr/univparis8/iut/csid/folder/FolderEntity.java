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
    private Set<FileEntity> childrenFile;

    @OneToOne(optional = true, cascade = CascadeType.MERGE)
    @JoinColumn(name="parent_folder_id")
    private FolderEntity parentFolder;

    @OneToMany(mappedBy = "parentFolder", cascade = CascadeType.ALL)
    private Set<FolderEntity> childrenFolder;

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

    public Set<FileEntity> getChildrenFile() {
        return childrenFile;
    }

    public void setChildrenFile(Set<FileEntity> childrenFile) {
        this.childrenFile = childrenFile;
    }

    public FolderEntity getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(FolderEntity parentFolder) {
        this.parentFolder = parentFolder;
    }

    public Set<FolderEntity> getChildrenFolder() {
        return childrenFolder;
    }

    public void setChildrenFolder(Set<FolderEntity> childrenFolder) {
        this.childrenFolder = childrenFolder;
    }

    public static final class FolderEntityBuilder {
        private String id;
        private String name;
        private Set<FileEntity> childrenFile;
        private FolderEntity parentFolder;
        private Set<FolderEntity> childrenFolder;

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

        public FolderEntityBuilder withChildrenFile(Set<FileEntity> childrenFile) {
            this.childrenFile = childrenFile;
            return this;
        }

        public FolderEntityBuilder withParentFolder(FolderEntity parentFolder) {
            this.parentFolder = parentFolder;
            return this;
        }

        public FolderEntityBuilder withChildrenFolder(Set<FolderEntity> childrenFolder) {
            this.childrenFolder = childrenFolder;
            return this;
        }

        public FolderEntity build() {
            FolderEntity folderEntity = new FolderEntity();
            folderEntity.setId(id);
            folderEntity.setName(name);
            folderEntity.setChildrenFile(childrenFile);
            folderEntity.setParentFolder(parentFolder);
            folderEntity.setChildrenFolder(childrenFolder);
            return folderEntity;
        }
    }
}
