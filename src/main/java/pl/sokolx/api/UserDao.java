package pl.sokolx.api;

import pl.sokolx.models.User;

import java.util.List;

public interface UserDao {

    void createUser(User user);

    void deleteUser(String lastName);

    List<User> getAllUsers();

    void updateUser(User user);
}