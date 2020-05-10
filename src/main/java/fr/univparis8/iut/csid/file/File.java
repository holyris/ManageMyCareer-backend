package fr.univparis8.iut.csid.file;


import fr.univparis8.iut.csid.user.User;
import fr.univparis8.iut.csid.user.UserEntity;

import java.util.Date;
import java.util.Objects;

public class File {
    private final String id;
    private final String name;
    private final String type;
    private final String documentType;
    private final Long size;
    private final Date addedDate;
    private final Date modifiedDate;
    private final Date dateOfDoc;
    private final String company;
    private final String workplace;
    private final Double grossSalary;
    private final Double netSalary;
    private final FileContentEntity fileContent;
    private final User user;

    public File(String id, String name, String type, String documentType, Long size, Date addedDate, Date modifiedDate, Date dateOfDoc, String company, String workplace, Double grossSalary, Double netSalary, FileContentEntity fileContent, User user) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.documentType = documentType;
        this.size = size;
        this.addedDate = addedDate;
        this.modifiedDate = modifiedDate;
        this.dateOfDoc = dateOfDoc;
        this.company = company;
        this.workplace = workplace;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
        this.fileContent = fileContent;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDocumentType() {
        return documentType;
    }

    public Long getSize() {
        return size;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public Date getDateOfDoc() {
        return dateOfDoc;
    }

    public String getCompany() {
        return company;
    }

    public String getWorkplace() {
        return workplace;
    }

    public Double getGrossSalary() {
        return grossSalary;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public FileContentEntity getFileContent() {
        return fileContent;
    }

    public User getUserEntity() {
        return user;
    }

    public File mergeWith(File other) {
        return FileBuilder.create()
                .withId(id)
                .withName(other.name != null ? other.name : name)
                .withType(other.type != null ? other.type : type)
                .withDocumentType(other.documentType != null ? other.documentType : documentType)
                .withSize(other.size != null ? other.size : size)
                .withDateOfDoc(other.dateOfDoc != null ? other.dateOfDoc : dateOfDoc)
                .withAddedDate(other.addedDate != null ? other.addedDate : addedDate)
                .withModifiedDate(other.modifiedDate != null ? other.modifiedDate : modifiedDate)
                .withCompany(other.company != null ? other.company : company)
                .withWorkplace(other.workplace != null ? other.workplace : workplace)
                .withGrossSalary(other.grossSalary != null ? other.grossSalary : grossSalary)
                .withNetSalary(other.netSalary != null ? other.netSalary : netSalary)
                .withFileContent(fileContent)
                .withUser((Objects.requireNonNullElse(other.user, user)))
                .build();
    }


    public static final class FileBuilder{

        private String id;
        private String name;
        private String type;
        private String documentType;
        private Long size;
        private Date addedDate;
        private Date modifiedDate;
        private Date dateOfDoc;
        private String company;
        private String workplace;
        private Double grossSalary;
        private Double netSalary;
        private FileContentEntity fileContent;
        private User user;

        public FileBuilder() {
        }

        public static FileBuilder create() {
            return new FileBuilder();
        }

        public FileBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FileBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FileBuilder withDocumentType(String documentType) {
            this.documentType = documentType;
            return this;
        }

        public FileBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileBuilder withDateOfDoc(Date dateOfDoc) {
            this.dateOfDoc = dateOfDoc;
            return this;
        }

        public FileBuilder withAddedDate(Date addedDate) {
            this.addedDate = addedDate;
            return this;
        }

        public FileBuilder withModifiedDate(Date modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public FileBuilder withCompany(String company) {
            this.company = company;
            return this;
        }
        
        public FileBuilder withWorkplace(String workplace) {
            this.workplace = workplace;
            return this;
        }
        
        public FileBuilder withGrossSalary(Double grossSalary) {
            this.grossSalary = grossSalary;
            return this;
        }
        
        public FileBuilder withNetSalary(Double netSalary) {
            this.netSalary = netSalary;
            return this;
        }
        
        

        public FileBuilder withFileContent(FileContentEntity fileContent) {
            this.fileContent = fileContent;
            return this;
        }

        public FileBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public File build() {
            return new File(id, name, type, documentType, size, addedDate, modifiedDate, dateOfDoc, company, workplace, grossSalary, netSalary, fileContent, user);
        }
    }
}
