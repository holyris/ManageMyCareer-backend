package fr.univparis8.iut.csid.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.univparis8.iut.csid.file.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private String username;

    @Autowired
    private String password;

    @Autowired
    private String enabled;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FileEntity> fileEntities;

    public UserEntity(){
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<FileEntity> getFileEntities() {
        return fileEntities;
    }

    public void setFileEntities(Set<FileEntity> fileEntities) {
        this.fileEntities = fileEntities;
    }

    public static final class UserEntityBuilder{
        private String username;
        private String password;
        private String enabled;
        private Set<FileEntity> fileEntities;

        private UserEntityBuilder(){

        }

        public static UserEntityBuilder create(){
            return new UserEntityBuilder();
        }

        public UserEntityBuilder withUsername(String username){
            this.username = username;
            return this;
        }

        public UserEntityBuilder withPassword(String password){
            this.password = password;
            return this;
        }

        public UserEntityBuilder withEnabled(String enabled){
            this.enabled = enabled;
            return this;
        }

        public UserEntityBuilder withFileEntities(Set<FileEntity> fileEntities){
            this.fileEntities = fileEntities;
            return this;
        }


        public UserEntity build(){
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userEntity.setEnabled(enabled);
            userEntity.setFileEntities(fileEntities);
            return userEntity;
        }


    }
}

