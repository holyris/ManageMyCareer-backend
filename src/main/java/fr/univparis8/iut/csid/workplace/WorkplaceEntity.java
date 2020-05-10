package fr.univparis8.iut.csid.workplace;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.univparis8.iut.csid.company.Company;
import fr.univparis8.iut.csid.company.CompanyEntity;
import fr.univparis8.iut.csid.file.FileEntity;
import fr.univparis8.iut.csid.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "workplace")
public class WorkplaceEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private CompanyEntity companyEntity;

    public WorkplaceEntity() {
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

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public static final class WorkplaceEntityBuilder{
        private String id;
        private String name;
        private String description;
        private CompanyEntity companyEntity;

        public WorkplaceEntityBuilder(){
        }

        public static WorkplaceEntityBuilder create(){
            return new WorkplaceEntityBuilder();
        }

        public WorkplaceEntityBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public WorkplaceEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public WorkplaceEntityBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public WorkplaceEntityBuilder withCompany(CompanyEntity companyEntity) {
            this.companyEntity = companyEntity;
            return this;
        }

        public WorkplaceEntity build() {
            WorkplaceEntity workplaceEntity = new WorkplaceEntity();
            workplaceEntity.setId(id);
            workplaceEntity.setName(name);
            workplaceEntity.setDescription(description);
            workplaceEntity.setCompanyEntity(companyEntity);
            return workplaceEntity;
        }
    }
}
