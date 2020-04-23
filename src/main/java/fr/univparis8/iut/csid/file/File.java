package fr.univparis8.iut.csid.file;


import java.util.Date;
import java.util.Objects;

public class File {
    private final String id;
    private final String name;
    private final String type;
    private final String typeFile;
    private final Long size;
    private final Date date;
    private final String company;
    private final String workplace;
    private final Double grossSalary;
    private final Double netSalary;
    private final FileContentEntity fileContent;

    public File(String id, String name, String type, String typeFile, Long size, Date date, String company, String workplace, Double grossSalary, Double netSalary, FileContentEntity fileContent) {
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

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public Long getSize() {
        return size;
    }

    public Date getDate() {
        return date;
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

    public File mergeWith(File other) {
        return FileBuilder.create()
                .withId(id)
                .withName(Objects.requireNonNullElse(other.name, name))
                .withType(Objects.requireNonNullElse(other.type, type))
                .withTypeFile(Objects.requireNonNullElse(other.typeFile, typeFile))
                .withSize((Objects.requireNonNullElse(other.size, size)))
                .withDate((Objects.requireNonNullElse(other.date, date)))
                .withCompany((Objects.requireNonNullElse(other.company, company)))
                .withWorkplace((Objects.requireNonNullElse(other.workplace, workplace)))
                .withGrossSalary((Objects.requireNonNullElse(other.grossSalary, grossSalary)))
                .withNetSalary((Objects.requireNonNullElse(other.netSalary, netSalary)))
                .withFileContent((Objects.requireNonNullElse(other.fileContent, fileContent)))
                .build();
    }


    public static final class FileBuilder{

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
        private FileContentEntity fileContent;

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

        public FileBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileBuilder withTypeFile(String typeFile) {
            this.typeFile = typeFile;
            return this;
        }

        public FileBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileBuilder withDate(Date date) {
            this.date = date;
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

        public File build() {
            return new File(id, name, type, typeFile, size, date, company, workplace, grossSalary, netSalary, fileContent);
        }
    }
}
