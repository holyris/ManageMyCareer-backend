package fr.univparis8.iut.csid.workplace;

import fr.univparis8.iut.csid.company.Company;
import fr.univparis8.iut.csid.file.File;

import java.util.Objects;

public class Workplace {

    private final String id;
    private final String name;
    private final String description;
    private final Company company;

    public Workplace(String id, String name, String description, Company company) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public Workplace mergeWith(Workplace other) {
        return Workplace.WorkplaceBuilder.create()
                .withId(id)
                .withName(other.name != null ? other.name : name)
                .withDescription(other.description !=  null ? other.description : description)
                .withCompany(other.company != null ? other.company : company)
                .build();
    }


    public static final class WorkplaceBuilder{
        private String id;
        private String name;
        private String description;
        private Company company;

        public WorkplaceBuilder(){

        }

        public static WorkplaceBuilder create(){
            return new WorkplaceBuilder();
        }

        public WorkplaceBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public WorkplaceBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public WorkplaceBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public WorkplaceBuilder withCompany(Company company) {
            this.company = company;
            return this;
        }

        public Workplace build(){
            return new Workplace(id, name, description, company);
        }
    }
}
