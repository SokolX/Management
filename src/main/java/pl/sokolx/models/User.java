package pl.sokolx.models;

public class User {

    private Integer userId;
    private String userLogin;
    private String userPassword;
    private String userFirstName;
    private String userLastName;

    public User(Integer userId, String userLogin, String userPassword, String userFirstName, String userLastName) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public User(String userLogin, String userPassword, String userFirstName, String userLastName) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public User(Integer userId, String userPassword, String userFirstName, String userLastName) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }


    public User(Integer userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                '}';
    }
}
