package fr.univparis8.iut.csid.user;

public class ChangePasswordDto {

    private String oldPassword;
    private String newPassword;

    public ChangePasswordDto() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
