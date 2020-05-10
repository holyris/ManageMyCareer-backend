package fr.univparis8.iut.csid.file;

import java.util.Date;

public class FileReceiveDto {

    private String id;
    private String name;
    private String type;
    private String documentType;
    private Long size;
    private Date dateOfDoc;
    private Date addedDate;
    private Date modifiedDate;
    private String company;
    private String workplace;
    private Double grossSalary;
    private Double netSalary;
    private byte[] fileContent;
    private String userId;

    public FileReceiveDto() {
    }

    public FileReceiveDto(String id, String name, String type, String documentType, Long size, Date dateOfDoc, Date addedDate, Date modifiedDate, String company, String workplace, Double grossSalary, Double netSalary, byte[] fileContent, String userId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.documentType = documentType;
        this.size = size;
        this.dateOfDoc = dateOfDoc;
        this.addedDate = addedDate;
        this.modifiedDate = modifiedDate;
        this.company = company;
        this.workplace = workplace;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
        this.fileContent = fileContent;
        this.userId = userId;
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

    public Date getDateOfDoc() {
        return dateOfDoc;
    }

    public void setDateOfDoc(Date dateOfDoc) {
        this.dateOfDoc = dateOfDoc;
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

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static final class FileReceiveDtoBuilder{

        private String id;
        private String name;
        private String type;
        private String documentType;
        private Long size;
        private Date dateOfDoc;
        private Date addedDate;
        private Date modifiedDate;
        private String company;
        private String workplace;
        private Double grossSalary;
        private Double netSalary;
        private byte[] fileContent;
        private String userId;

        public FileReceiveDtoBuilder() {
        }

        public static FileReceiveDtoBuilder create(){return new FileReceiveDtoBuilder();}

        public FileReceiveDtoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FileReceiveDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FileReceiveDtoBuilder withDocumentType(String documentType) {
            this.documentType = documentType;
            return this;
        }

        public FileReceiveDtoBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileReceiveDtoBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileReceiveDtoBuilder withDateOfDoc(Date dateOfDoc) {
            this.dateOfDoc = dateOfDoc;
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

        public FileReceiveDtoBuilder withFileContent(byte[] fileContent) {
            this.fileContent = fileContent;
            return this;
        }

        public FileReceiveDtoBuilder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public FileReceiveDto build() {
            FileReceiveDto fileResponseDto = new FileReceiveDto();
            fileResponseDto.setId(id);
            fileResponseDto.setName(name);
            fileResponseDto.setType(type);
            fileResponseDto.setDocumentType(documentType);
            fileResponseDto.setSize(size);
            fileResponseDto.setDateOfDoc(dateOfDoc);
            fileResponseDto.setAddedDate(addedDate);
            fileResponseDto.setModifiedDate(modifiedDate);
            fileResponseDto.setCompany(company);
            fileResponseDto.setWorkplace(workplace);
            fileResponseDto.setGrossSalary(grossSalary);
            fileResponseDto.setNetSalary(netSalary);
            fileResponseDto.setUserId(userId);
            fileResponseDto.setFileContent(fileContent);
            return fileResponseDto;
        }
    }
}
