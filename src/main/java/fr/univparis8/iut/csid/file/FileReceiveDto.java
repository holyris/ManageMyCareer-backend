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
    private byte[] fileContent;

    public FileReceiveDto() {
    }

  public FileReceiveDto(String id, String name, String type, String documentType, Long size, Date documentDate, Date addedDate, Date modifiedDate, String company, String workplace, Double grossSalary, Double netSalary, byte[] fileContent) {
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
        this.fileContent = fileContent;
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

    public String getType() {
        return type;
    }

  public String getDocumentType() {
    return documentType;
  }

  public Long getSize() {
    return size;
  }

  public Date getDocumentDate() {
    return documentDate;
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

    public String getWorkplace() {
        return workplace;
    }

    public Double getGrossSalary() {
        return grossSalary;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

}
