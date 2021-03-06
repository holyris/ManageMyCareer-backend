package fr.univparis8.iut.csid.file;

import java.util.Date;

public class FileReceiveDto {

    private String id;
    private String name;
    private String type;
    private String documentType;
    private Long size;
    private Date documentDate;
    private Date addedDate;
    private Date modifiedDate;
    private String company;
    private String workplace;
    private Double grossSalary;
    private Double netSalary;
    private String folderId;
    private byte[] fileContent;

    public FileReceiveDto() {
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

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
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

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }


    public static final class FileReceiveDtoBuilder {
        private String id;
        private String name;
        private String type;
        private String documentType;
        private Long size;
        private Date documentDate;
        private Date addedDate;
        private Date modifiedDate;
        private String company;
        private String workplace;
        private Double grossSalary;
        private Double netSalary;
        private String folderId;
        private byte[] fileContent;

        private FileReceiveDtoBuilder() {
        }

        public static FileReceiveDtoBuilder create() {
            return new FileReceiveDtoBuilder();
        }

        public FileReceiveDtoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FileReceiveDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FileReceiveDtoBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileReceiveDtoBuilder withDocumentType(String documentType) {
            this.documentType = documentType;
            return this;
        }

        public FileReceiveDtoBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileReceiveDtoBuilder withDocumentDate(Date documentDate) {
            this.documentDate = documentDate;
            return this;
        }

        public FileReceiveDtoBuilder withAddedDate(Date addedDate) {
            this.addedDate = addedDate;
            return this;
        }

        public FileReceiveDtoBuilder withModifiedDate(Date modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public FileReceiveDtoBuilder withCompany(String company) {
            this.company = company;
            return this;
        }

        public FileReceiveDtoBuilder withWorkplace(String workplace) {
            this.workplace = workplace;
            return this;
        }

        public FileReceiveDtoBuilder withGrossSalary(Double grossSalary) {
            this.grossSalary = grossSalary;
            return this;
        }

        public FileReceiveDtoBuilder withNetSalary(Double netSalary) {
            this.netSalary = netSalary;
            return this;
        }

        public FileReceiveDtoBuilder withFolderId(String folderId) {
            this.folderId = folderId;
            return this;
        }

        public FileReceiveDtoBuilder withFileContent(byte[] fileContent) {
            this.fileContent = fileContent;
            return this;
        }

        public FileReceiveDto build() {
            FileReceiveDto fileReceiveDto = new FileReceiveDto();
            fileReceiveDto.setId(id);
            fileReceiveDto.setName(name);
            fileReceiveDto.setType(type);
            fileReceiveDto.setDocumentType(documentType);
            fileReceiveDto.setSize(size);
            fileReceiveDto.setDocumentDate(documentDate);
            fileReceiveDto.setAddedDate(addedDate);
            fileReceiveDto.setModifiedDate(modifiedDate);
            fileReceiveDto.setCompany(company);
            fileReceiveDto.setWorkplace(workplace);
            fileReceiveDto.setGrossSalary(grossSalary);
            fileReceiveDto.setNetSalary(netSalary);
            fileReceiveDto.setFolderId(folderId);
            fileReceiveDto.setFileContent(fileContent);
            return fileReceiveDto;
        }
    }
}
