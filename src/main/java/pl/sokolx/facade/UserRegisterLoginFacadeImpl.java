package pl.sokolx.facade;

import pl.sokolx.api.UserRegisterLoginFacade;
import pl.sokolx.api.UserService;
import pl.sokolx.exception.UserLoginAlreadyExistException;
import pl.sokolx.exception.UserShortLengthLoginException;
import pl.sokolx.exception.UserShortLengthPasswordException;
import pl.sokolx.models.User;
import pl.sokolx.service.UserServiceImpl;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {

    private static UserRegisterLoginFacade instance = null;
    private final UserService userService = UserServiceImpl.getInstance();

    public UserRegisterLoginFacadeImpl() {
    }

    public static UserRegisterLoginFacade getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    @Override
    public String registerUser(User user) {
        try {
            userService.addUser(user);
            return "Register successfully";
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (UserShortLengthLoginException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public boolean loginUser(String login, String password) {
        return userService.isCorrectLoginAndPassword(login, password);
    }
}
