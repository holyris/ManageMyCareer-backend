package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<FolderEntity, String> {
    FolderEntity getByIdAndUserEntity(String id, UserEntity userEntity);

    List<FolderEntity> findAllByUserEntity(UserEntity userEntity);

    List<FolderEntity> findAllByUserEntityAndParentFolder(UserEntity userEntity, FolderEntity folderEntity);
}
