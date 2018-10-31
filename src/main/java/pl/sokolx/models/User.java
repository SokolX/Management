package pl.sokolx.models;

public class User {

    public final static String USER_SEPARATOR = ",";

    private Long userId;
    private String userLogin;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private RoleType roleType;

    public User(Long userId, String userLogin, String userPassword, String userFirstName, String userLastName, RoleType roleType) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.roleType = roleType;
    }

    public User(String userLogin, String userPassword, String userFirstName, String userLastName, RoleType roleType) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.roleType = roleType;
    }

    public User(Long userId, String userLogin, String userPassword, String userFirstName, String userLastName) {
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

    public User(Long userId, String userPassword, String userFirstName, String userLastName) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }


    public User(Long userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

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

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public RoleType getUserRole() {
        return roleType;
    }

    @Override
    public String toString() {
        return userId + USER_SEPARATOR
                + userLogin + USER_SEPARATOR
                + userPassword + USER_SEPARATOR
                + userFirstName + USER_SEPARATOR
                + userLastName + USER_SEPARATOR
                + roleType;
    }
}
