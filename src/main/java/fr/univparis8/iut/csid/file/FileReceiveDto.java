package fr.univparis8.iut.csid.file;

import java.util.Date;

public class FileReceiveDto {

    private String id;
    private String name;
    private String type;
    private String typeFile;
    private Long size;
    private Date date;
    private String company;
    private String workplace;
    private Double grossSalary;
    private Double netSalary;
    private byte[] fileContent;

    public FileReceiveDto() {
    }

    public FileReceiveDto(String id, String name, String type, String typeFile, Long size, Date date, String company, String workplace, Double grossSalary, Double netSalary, byte[] fileContent) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.typeFile = typeFile;
        this.size = size;
        this.date = date;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(String typeFile) {
        this.typeFile = typeFile;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public static final class FileReceiveDtoBuilder{
        private String id;
        private String name;
        private String type;
        private String typeFile;
        private Long size;
        private Date date;
        private String company;
        private String workplace;
        private Double grossSalary;
        private Double netSalary;
        private byte[] fileContent;

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

        public FileReceiveDtoBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileReceiveDtoBuilder withTypeFile(String typeFile) {
            this.typeFile = typeFile;
            return this;
        }

        public FileReceiveDtoBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileReceiveDtoBuilder withDate(Date date) {
            this.date = date;
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

        public FileReceiveDto build() {
            FileReceiveDto fileReceiveDtoDto = new FileReceiveDto();
            fileReceiveDtoDto.setId(id);
            fileReceiveDtoDto.setName(name);
            fileReceiveDtoDto.setType(type);
            fileReceiveDtoDto.setTypeFile(typeFile);
            fileReceiveDtoDto.setSize(size);
            fileReceiveDtoDto.setDate(date);
            fileReceiveDtoDto.setCompany(company);
            fileReceiveDtoDto.setWorkplace(workplace);
            fileReceiveDtoDto.setGrossSalary(grossSalary);
            fileReceiveDtoDto.setNetSalary(netSalary);
            fileReceiveDtoDto.setFileContent(fileContent);
            return fileReceiveDtoDto;
        }
    }
}
