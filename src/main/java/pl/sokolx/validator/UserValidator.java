package pl.sokolx.validator;

import pl.sokolx.exception.UserShortLengthLoginException;
import pl.sokolx.exception.UserShortLengthPasswordException;
import pl.sokolx.models.User;

public class UserValidator {

    public static final int MIN_LENGTH_PASSWORD = 6;
    public static final int MIN_LENGTH_LOGIN = 4;

    private static UserValidator instance = null;

    public UserValidator() {
    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }

        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException {

        if(isPasswordLengthNoEnough(user.getUserPassword())) {

            throw new UserShortLengthPasswordException("Password is too short");

        } else if(isLoginLengthNoEnough(user.getUserLogin())) {

            throw new UserShortLengthLoginException("Login " + user.getUserLogin() + " is too short");

        }

        return true;
    }

    private boolean isPasswordLengthNoEnough(String password) {

        return password.length() < MIN_LENGTH_PASSWORD;

    }

    private boolean isLoginLengthNoEnough(String login) {

        return login.length() < MIN_LENGTH_LOGIN;

    }

}
