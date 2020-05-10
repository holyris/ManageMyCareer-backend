package fr.univparis8.iut.csid.workplace;

import fr.univparis8.iut.csid.company.CompanyEntity;

public class WorkplaceDto {

    private String id;
    private String name;
    private String description;
    private String companyId;

    public WorkplaceDto(String id, String name, String description, String companyId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.companyId = companyId;
    }

    public WorkplaceDto() {
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public static final class WorkplaceDtoBuilder{

        private String id;
        private String name;
        private String description;
        private String companyId;

        public WorkplaceDtoBuilder(){}

        public static WorkplaceDtoBuilder create(){
            return new WorkplaceDtoBuilder();
        }

        public WorkplaceDtoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public WorkplaceDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public WorkplaceDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public WorkplaceDtoBuilder withCompanyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public WorkplaceDto build() {
            WorkplaceDto workplaceDto = new WorkplaceDto();
            workplaceDto.setId(id);
            workplaceDto.setName(name);
            workplaceDto.setDescription(description);
            workplaceDto.setCompanyId(companyId);
            return workplaceDto;
        }


    }
}
