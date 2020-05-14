package fr.univparis8.iut.csid.company;

import fr.univparis8.iut.csid.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {
    List<CompanyEntity> findAllByUserEntity(UserEntity userEntity);
}
