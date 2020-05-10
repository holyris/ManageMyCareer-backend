package fr.univparis8.iut.csid.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.univparis8.iut.csid.file.FileContentEntity;
import fr.univparis8.iut.csid.file.FileEntity;
import fr.univparis8.iut.csid.user.UserEntity;
import fr.univparis8.iut.csid.workplace.Workplace;
import fr.univparis8.iut.csid.workplace.WorkplaceEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "companyEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<WorkplaceEntity> workplaceEntities;

   /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private UserEntity userEntity;*/

    public CompanyEntity() {
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

    public Set<WorkplaceEntity> getWorkplaceEntities() {
        return workplaceEntities;
    }

    public void setWorkplaceEntities(Set<WorkplaceEntity> workplaceEntities) {
        this.workplaceEntities = workplaceEntities;
    }

   /* public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }*/

    public static final class CompanyEntityBuilder {
        private String id;
        private String name;
        private String description;
        private Set<WorkplaceEntity> workplaceEntities;
        private UserEntity userEntity;

        public CompanyEntityBuilder() {
        }

        public static CompanyEntityBuilder create() {
            return new CompanyEntityBuilder();
        }

        public CompanyEntityBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public CompanyEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }
        public CompanyEntityBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CompanyEntityBuilder withWorkplaceEntities(Set<WorkplaceEntity> workplaceEntities) {
            this.workplaceEntities = workplaceEntities;
            return this;
        }

        public CompanyEntityBuilder withUserEntity(UserEntity userEntity) {
            this.userEntity = userEntity;
            return this;
        }


        public CompanyEntity build() {
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setId(id);
            companyEntity.setName(name);
            companyEntity.setDescription(description);
            companyEntity.setWorkplaceEntities(workplaceEntities);
            /*companyEntity.setUserEntity(userEntity);*/
            return companyEntity;
        }
    }

    }
