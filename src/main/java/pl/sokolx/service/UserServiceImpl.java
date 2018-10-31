package pl.sokolx.service;

import pl.sokolx.api.UserDao;
import pl.sokolx.api.UserService;
import pl.sokolx.dao.UserDaoImpl;
import pl.sokolx.exception.UserLoginAlreadyExistException;
import pl.sokolx.exception.UserShortLengthLoginException;
import pl.sokolx.exception.UserShortLengthPasswordException;
import pl.sokolx.models.User;
import pl.sokolx.validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException {
        if (isLoginAlreadyExist(user.getUserLogin())) {
            throw new UserLoginAlreadyExistException();
        }

        if (userValidator.isValidate(user)) {
            userDao.saveUser(user);
            return true;
        }

        return false;
    }

    public void removeUserById(Long userId) {
        userDao.removeUserById(userId);
    }

    private boolean isLoginAlreadyExist(String login) {
        User user = getUserByLogin(login);

        return user != null;
    }

    public User getUserById(Long userId) {
        List<User> users = getAllUsers();

        for (User user : users
        ) {
            boolean isFoundUser = user.getUserId().equals(userId);
            if (isFoundUser) {
                return user;
            }

        }

        return null;
    }

    public User getUserByLogin(String login) {

        List<User> users = getAllUsers();

            for (User user : users) {
                boolean isFoundUser = user.getUserLogin().equals(login);
                if (isFoundUser) {
                    return user;
                }

            }

            return null;
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {
        User foundUser = getUserByLogin(login);

        if (foundUser == null) {
            return false;
        }

        boolean isCorrectLogin = foundUser.getUserLogin().equals(login);
        boolean isCorrectPass = foundUser.getUserPassword().equals(password);

        return isCorrectLogin && isCorrectPass;
    }
}
