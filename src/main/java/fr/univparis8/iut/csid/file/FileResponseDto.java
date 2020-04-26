package fr.univparis8.iut.csid.file;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FileResponseDto {
    private String id;
    private String name;
    private String type;
    private String documentType;
    @JsonProperty( access = JsonProperty.Access.READ_ONLY)
    private Long size;
    @JsonProperty( access = JsonProperty.Access.READ_ONLY)
    private Date addedDate;
    private Date modifiedDate;
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Date documentDate;
  private String company;
    private String workplace;
    @JsonProperty( access = JsonProperty.Access.READ_ONLY)
    private Double grossSalary;
    @JsonProperty( access = JsonProperty.Access.READ_ONLY)
    private Double netSalary;

    public FileResponseDto() {
    }

  public FileResponseDto(String id, String name, String type, String documentType, Long size, Date documentDate, Date addedDate, Date modifiedDate, String company, String workplace, Double grossSalary, Double netSalary) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.documentType = documentType;
    this.size = size;
    this.documentDate = documentDate;
    this.addedDate = addedDate;
    this.modifiedDate = modifiedDate;
    this.company = company;
    this.workplace = workplace;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
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

    public static final class FileDtoBuilder{
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

        public FileDtoBuilder() {
        }

        public static FileDtoBuilder create(){return new FileDtoBuilder();}

        public FileDtoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FileDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FileDtoBuilder withDocumentType(String documentType) {
            this.documentType = documentType;
            return this;
        }

        public FileDtoBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileDtoBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileDtoBuilder withDateOfDoc(Date dateOfDoc) {
            this.dateOfDoc = dateOfDoc;
            return this;
        }

        public FileDtoBuilder withAddedDate(Date addedDate) {
            this.addedDate = addedDate;
            return this;
        }

        public FileDtoBuilder withModifiedDate(Date modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public FileDtoBuilder withCompany(String company) {
            this.company = company;
            return this;
        }

        public FileDtoBuilder withWorkplace(String workplace) {
            this.workplace = workplace;
            return this;
        }

        public FileDtoBuilder withGrossSalary(Double grossSalary) {
            this.grossSalary = grossSalary;
            return this;
        }

        public FileDtoBuilder withNetSalary(Double netSalary) {
            this.netSalary = netSalary;
            return this;
        }

        public FileResponseDto build() {
            FileResponseDto fileResponseDto = new FileResponseDto();
            fileResponseDto.setId(id);
            fileResponseDto.setName(name);
            fileResponseDto.setType(type);
            fileResponseDto.setDocumentType(documentType);
          fileResponseDto.setSize(size);
          fileResponseDto.setDocumentDate(dateOfDoc);
          fileResponseDto.setAddedDate(addedDate);
            fileResponseDto.setModifiedDate(modifiedDate);
            fileResponseDto.setCompany(company);
            fileResponseDto.setWorkplace(workplace);
            fileResponseDto.setGrossSalary(grossSalary);
            fileResponseDto.setNetSalary(netSalary);
            return fileResponseDto;
        }
    }
}
