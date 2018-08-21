package pl.sokolx.api;

import pl.sokolx.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void removeUserById(Long userId);


}
