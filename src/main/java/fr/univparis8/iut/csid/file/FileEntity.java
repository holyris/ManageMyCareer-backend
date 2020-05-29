package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.folder.FolderEntity;
import fr.univparis8.iut.csid.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file" )
public class FileEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String type;
    private String documentType;
    private Long size;
    private Date addedDate;
    private Date modifiedDate;
    private Date documentDate;
    private String company;
    private String workplace;
    private Double grossSalary;
    private Double netSalary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id", referencedColumnName = "id")
    private FolderEntity folderEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private UserEntity userEntity;

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

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public Date getDocumentDate() {
    return documentDate;
  }

  public void setDocumentDate(Date dateOfDoc) {
    this.documentDate = dateOfDoc;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public FileContentEntity getFileContent() {
        return fileContent;
    }

    public void setFileContent(FileContentEntity fileContent) {
        this.fileContent = fileContent;
    }

    public FolderEntity getFolderEntity() {
        return folderEntity;
    }

    public void setFolderEntity(FolderEntity folderEntity) {
        this.folderEntity = folderEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public static final class FileEntityBuilder {
        private String id;
        private String name;
        private String type;
        private String documentType;
        private Long size;
        private Date addedDate;
        private Date modifiedDate;
        private Date documentDate;
        private String company;
        private String workplace;
        private Double grossSalary;
        private Double netSalary;
        private FileContentEntity fileContent;
        private UserEntity userEntity;
        private FolderEntity folderEntity;



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

        public FileEntityBuilder withDocumentType(String documentType) {
            this.documentType = documentType;
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

        public FileEntityBuilder withDocumentDate(Date documentDate) {
            this.documentDate = documentDate;
            return this;
        }

        public FileEntityBuilder withAddedDate(Date addedDate) {
            this.addedDate = addedDate;
            return this;
        }

        public FileEntityBuilder withModifiedDate(Date modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public FileEntityBuilder withCompany(String company) {
            this.company = company;
            return this;
        }

        public FileEntityBuilder withWorkplace(String workplace) {
            this.workplace = workplace;
            return this;
        }

        public FileEntityBuilder withGrossSalary(Double grossSalary) {
            this.grossSalary = grossSalary;
            return this;
        }

        public FileEntityBuilder withNetSalary(Double netSalary) {
            this.netSalary = netSalary;
            return this;
        }

        public FileEntityBuilder withUserEntity(UserEntity userEntity) {
            this.userEntity = userEntity;
            return this;
        }

        public FileEntityBuilder withFolderEntity(FolderEntity folderEntity) {
            this.folderEntity = folderEntity;
            return this;
        }

        public FileEntity build() {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setId(id);
            fileEntity.setName(name);
            fileEntity.setType(type);
            fileEntity.setDocumentType(documentType);
            fileEntity.setSize(size);
            fileEntity.setFileContent(fileContent);
            fileEntity.setAddedDate(addedDate);
            fileEntity.setModifiedDate(modifiedDate);
            fileEntity.setDocumentDate(documentDate);
            fileEntity.setCompany(company);
            fileEntity.setWorkplace(workplace);
            fileEntity.setGrossSalary(grossSalary);
            fileEntity.setNetSalary(netSalary);
            fileEntity.setUserEntity(userEntity);
            fileEntity.setFolderEntity(folderEntity);
            return fileEntity;
        }


    }

}
