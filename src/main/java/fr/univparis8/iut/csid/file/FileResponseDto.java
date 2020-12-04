package fr.univparis8.iut.csid.file;

import java.util.Date;

public class FileResponseDto {
    private String id;
    private String name;
    private String type;
    private String documentType;
    private Long size;
    private Date addedDate;
    private Date modifiedDate;
    private Date documentDate;
    private String documentYear;
    private String documentMonth;
    private String company;
    private String workplace;
    private Double grossSalary;
    private Double netSalary;
    private String folderId;

    public FileResponseDto() {
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

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public String getDocumentYear() {
        return documentYear;
    }

    public void setDocumentYear(String documentYear) {
        this.documentYear = documentYear;
    }

    public String getDocumentMonth() {
        return documentMonth;
    }

    public void setDocumentMonth(String documentMonth) {
        this.documentMonth = documentMonth;
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


    public static final class FileResponseDtoBuilder {
        private String id;
        private String name;
        private String type;
        private String documentType;
        private Long size;
        private Date addedDate;
        private Date modifiedDate;
        private Date documentDate;
        private String documentYear;
        private String documentMonth;
        private String company;
        private String workplace;
        private Double grossSalary;
        private Double netSalary;
        private String folderId;

        private FileResponseDtoBuilder() {
        }

        public static FileResponseDtoBuilder create() {
            return new FileResponseDtoBuilder();
        }

        public FileResponseDtoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FileResponseDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FileResponseDtoBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileResponseDtoBuilder withDocumentType(String documentType) {
            this.documentType = documentType;
            return this;
        }

        public FileResponseDtoBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileResponseDtoBuilder withAddedDate(Date addedDate) {
            this.addedDate = addedDate;
            return this;
        }

        public FileResponseDtoBuilder withModifiedDate(Date modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public FileResponseDtoBuilder withDocumentDate(Date documentDate) {
            this.documentDate = documentDate;
            return this;
        }

        public FileResponseDtoBuilder withDocumentYear(String documentYear) {
            this.documentYear = documentYear;
            return this;
        }

        public FileResponseDtoBuilder withDocumentMonth(String documentMonth) {
            this.documentMonth = documentMonth;
            return this;
        }

        public FileResponseDtoBuilder withCompany(String company) {
            this.company = company;
            return this;
        }

        public FileResponseDtoBuilder withWorkplace(String workplace) {
            this.workplace = workplace;
            return this;
        }

        public FileResponseDtoBuilder withGrossSalary(Double grossSalary) {
            this.grossSalary = grossSalary;
            return this;
        }

        public FileResponseDtoBuilder withNetSalary(Double netSalary) {
            this.netSalary = netSalary;
            return this;
        }

        public FileResponseDtoBuilder withFolderId(String folderId) {
            this.folderId = folderId;
            return this;
        }

        public FileResponseDto build() {
            FileResponseDto fileResponseDto = new FileResponseDto();
            fileResponseDto.setId(id);
            fileResponseDto.setName(name);
            fileResponseDto.setType(type);
            fileResponseDto.setDocumentType(documentType);
            fileResponseDto.setSize(size);
            fileResponseDto.setAddedDate(addedDate);
            fileResponseDto.setModifiedDate(modifiedDate);
            fileResponseDto.setDocumentDate(documentDate);
            fileResponseDto.setDocumentYear(documentYear);
            fileResponseDto.setDocumentMonth(documentMonth);
            fileResponseDto.setCompany(company);
            fileResponseDto.setWorkplace(workplace);
            fileResponseDto.setGrossSalary(grossSalary);
            fileResponseDto.setNetSalary(netSalary);
            fileResponseDto.setFolderId(folderId);
            return fileResponseDto;
        }
    }
}
