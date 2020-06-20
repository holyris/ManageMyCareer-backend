package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.file.FileEntity;
import fr.univparis8.iut.csid.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;

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

    @OneToMany(mappedBy = "folderEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FileEntity> childFiles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_folder_id")
    private FolderEntity parentFolder;

    @OneToMany(mappedBy = "parentFolder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FolderEntity> childFolders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private UserEntity userEntity;

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

    public Set<FileEntity> getChildFiles() {
        return childFiles;
    }

    public void setChildFiles(Set<FileEntity> childFiles) {
        this.childFiles = childFiles;
    }

    public FolderEntity getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(FolderEntity parentFolder) {
        this.parentFolder = parentFolder;
    }

    public Set<FolderEntity> getChildFolders() {
        return childFolders;
    }

    public void setChildFolders(Set<FolderEntity> childFolders) {
        this.childFolders = childFolders;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public static final class FolderEntityBuilder {
        private String id;
        private String name;
        private Set<FileEntity> childFiles;
        private FolderEntity parentFolder;
        private Set<FolderEntity> childFolders;
        private UserEntity userEntity;

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

        public FolderEntityBuilder withChildFiles(Set<FileEntity> childFiles) {
            this.childFiles = childFiles;
            return this;
        }

        public FolderEntityBuilder withParentFolder(FolderEntity parentFolder) {
            this.parentFolder = parentFolder;
            return this;
        }

        public FolderEntityBuilder withChildFolders(Set<FolderEntity> childFolders) {
            this.childFolders = childFolders;
            return this;
        }

        public FolderEntityBuilder withUserEntity(UserEntity userEntity) {
            this.userEntity = userEntity;
            return this;
        }

        public FolderEntity build() {
            FolderEntity folderEntity = new FolderEntity();
            folderEntity.setId(id);
            folderEntity.setName(name);
            folderEntity.setChildFiles(childFiles);
            folderEntity.setParentFolder(parentFolder);
            folderEntity.setChildFolders(childFolders);
            folderEntity.setUserEntity(userEntity);
            return folderEntity;
        }
    }
}
