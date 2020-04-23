package fr.univparis8.iut.csid.file;

import java.util.Date;

public class FileDto {
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

    public FileDto() {
    }

    public FileDto(String id, String name, String type, String typeFile, Long size, Date date, String company, String workplace, Double grossSalary, Double netSalary) {
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

    public static final class FileDtoBuilder{
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

        public FileDtoBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileDtoBuilder withTypeFile(String typeFile) {
            this.typeFile = typeFile;
            return this;
        }

        public FileDtoBuilder withSize(Long size) {
            this.size = size;
            return this;
        }
        public FileDtoBuilder withDate(Date date) {
            this.date = date;
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

        public FileDto build() {
            FileDto fileDto = new FileDto();
            fileDto.setId(id);
            fileDto.setName(name);
            fileDto.setType(type);
            fileDto.setTypeFile(typeFile);
            fileDto.setSize(size);
            fileDto.setDate(date);
            fileDto.setCompany(company);
            fileDto.setWorkplace(workplace);
            fileDto.setGrossSalary(grossSalary);
            fileDto.setNetSalary(netSalary);
            return fileDto;
        }
    }
}
