package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.file.FileEntity;
import fr.univparis8.iut.csid.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<FolderEntity, String> {
    List<FolderEntity> findAllByUserEntity(UserEntity userEntity);

    List<FolderEntity> findAllByParentFolder(FolderEntity folderEntity);
}
