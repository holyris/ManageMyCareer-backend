package fr.univparis8.iut.csid.user;


import java.util.Objects;

public class User {

    private final String id;
    private final String username;
    private final String password;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User mergeWith(User other) {
        return User.UserBuilder.create()
                .withId(id)
                .withUsername(Objects.requireNonNullElse(other.username, username))
                .withPassword(Objects.requireNonNullElse(other.password, password))
                .build();
    }

    public static final class UserBuilder{

        private String id;
        private String username;
        private String password;

        public UserBuilder() {
        }

        public static UserBuilder create() {
            return new UserBuilder();
        }

        public UserBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(id, username, password);
        }
    }
}
