package fr.univparis8.iut.csid.company;

public class CompanyDto {

    private String id;
    private String name;
    private String description;
//    private String userId;

    public CompanyDto() {

    }

    public CompanyDto(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static final class CompanyDtoBuilder {

        private String id;
        private String name;
        private String description;

        public CompanyDtoBuilder() {
        }

        public static CompanyDtoBuilder create() {
            return new CompanyDtoBuilder();
        }

        public CompanyDtoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public CompanyDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CompanyDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CompanyDto build() {
            CompanyDto companyDto = new CompanyDto();
            companyDto.setId(id);
            companyDto.setName(name);
            companyDto.setDescription(description);
            return companyDto;
        }
    }

}
