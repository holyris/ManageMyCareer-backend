package fr.univparis8.iut.csid.company;

import fr.univparis8.iut.csid.file.File;
import fr.univparis8.iut.csid.file.FileContentEntity;
import fr.univparis8.iut.csid.user.User;
import fr.univparis8.iut.csid.workplace.Workplace;

import java.util.Date;

public class Company {

    private final String id;
    private final String name;
    private final String description;
    private final User user;

    public Company(String id, String name, String description, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public Company mergeWith(Company other) {
        return Company.CompanyBuilder.create()
                .withId(id)
                .withName(other.name != null ? other.name : name)
                .withDescription(other.description !=  null ? other.description : description)
                .build();
    }

    public static final class CompanyBuilder {

        private String id;
        private String name;
        private String description;
        private User user;

        public CompanyBuilder() {
        }

        public static CompanyBuilder create() {
            return new CompanyBuilder();
        }

        public CompanyBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public CompanyBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CompanyBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CompanyBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public Company build() {
            return new Company(id, name, description ,user);
        }
    }
}
