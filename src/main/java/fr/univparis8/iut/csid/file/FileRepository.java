package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.user.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {

    List<FileEntity> findAllByUserEntity(UserEntity userEntity);
}
