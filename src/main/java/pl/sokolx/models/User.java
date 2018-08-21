package pl.sokolx.models;

public class User {

    private Long userId;
    private String userLogin;
    private String userPassword;

    public User(Long userId, String userLogin, String userPassword) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
