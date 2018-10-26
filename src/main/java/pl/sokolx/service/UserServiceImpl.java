package pl.sokolx.service;

import pl.sokolx.api.UserDao;
import pl.sokolx.api.UserService;
import pl.sokolx.dao.UserDaoImpl;
import pl.sokolx.exception.UserLoginAlreadyExistException;
import pl.sokolx.models.User;
import pl.sokolx.validator.UserValidator;

import java.io.IOException;
import java.util.ArrayList;
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
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    public boolean addUser(User user) {
        try {
            if (isLoginAlreadyExist(user.getUserLogin())) {
                throw new UserLoginAlreadyExistException();
            }

            if (userValidator.isValidate(user)) {
                userDao.createUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /*
    public void removeUserById(Integer userId) {
        for(int i=0;i<users.size();i++){

            User userFromList = users.get(i);

            if (userFromList.getUserId().equals(userId)) {

                users.remove(i);

                break;
            }
        }
    }
*/
    private boolean isLoginAlreadyExist(String login) {
        User user = getUserByLogin(login);

        return user != null;
    }

    public User getUserById(Long userId) throws IOException {
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
        List<User> users = null;

        try {
            users = getAllUsers();
            for (User user : users
            ) {
                boolean isFoundUser = user.getUserLogin().equals(login);
                if (isFoundUser) {
                    return user;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
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
