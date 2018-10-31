package pl.sokolx.api;

import pl.sokolx.exception.UserLoginAlreadyExistException;
import pl.sokolx.exception.UserShortLengthLoginException;
import pl.sokolx.exception.UserShortLengthPasswordException;
import pl.sokolx.models.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException;

    void removeUserById(Long userId) throws IOException;

    List<User> getAllUsers() throws IOException;
    User getUserById(Long userId) throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password);

}
