package fr.univparis8.iut.csid.workplace;

import fr.univparis8.iut.csid.file.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepository extends JpaRepository<WorkplaceEntity, String> {
}
