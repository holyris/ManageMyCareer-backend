package fr.univparis8.iut.csid.workplace;

import fr.univparis8.iut.csid.company.CompanyEntity;
import fr.univparis8.iut.csid.file.FileEntity;
import fr.univparis8.iut.csid.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkplaceRepository extends JpaRepository<WorkplaceEntity, String> {
    List<WorkplaceEntity> findAllByCompanyEntity(CompanyEntity companyEntity);

}
