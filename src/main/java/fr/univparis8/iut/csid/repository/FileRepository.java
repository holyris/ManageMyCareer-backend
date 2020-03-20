package fr.univparis8.iut.csid.repository;

import fr.univparis8.iut.csid.entity.FileEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {

}
