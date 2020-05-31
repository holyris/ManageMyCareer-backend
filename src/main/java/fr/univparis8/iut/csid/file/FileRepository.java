package fr.univparis8.iut.csid.file;

import fr.univparis8.iut.csid.folder.FolderEntity;
import fr.univparis8.iut.csid.user.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {

    List<FileEntity> findAllByUserEntity(UserEntity userEntity);
    List<FileEntity> findAllByFolderEntity(FolderEntity folderEntity);

    @Query(value = "SELECT DISTINCT file.company FROM FileEntity file WHERE file.userEntity = :userEntity AND file.company IS NOT NULL AND file.company != ''")
    List<String> findCompaniesByUserEntity(@Param("userEntity") UserEntity userEntity);

    @Query(value = "SELECT DISTINCT file.workplace FROM FileEntity file WHERE file.userEntity = :userEntity AND file.workplace IS NOT NULL AND file.workplace != ''")
    List<String> findWorkplacesByUserEntity(@Param("userEntity") UserEntity userEntity);
}
