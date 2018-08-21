package pl.sokolx.service;

import org.junit.Assert;
import org.junit.Test;
import pl.sokolx.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Test
    public void testGetAllUsers() {

        //is
        List<User> users = new ArrayList<User>();
        users.add(new User(1l, "admin", "admin"));
        users.add(new User(2l, "pablo", "admin"));


        //then
        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestClass = userService.getAllUsers();

        //expected
        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testAddUser() {
        //is
        List<User> users = new ArrayList<User>();
        User user = new User(1l, "admin", "admin");
        users.add(user);
        //then
        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> usersFromTestClass = userService.getAllUsers();
        //expected
        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testRemoveUser() {
        //is
        List<User> users = new ArrayList<User>();
        User admin = new User(1l, "admin", "admin");
        User pablo = new User(2l, "pablo", "user");
        users.add(admin);
        users.add(pablo);
        //then
        UserServiceImpl userService = new UserServiceImpl(users);
        userService.removeUserById(1l);
        users.remove(admin);
        List<User> usersFromTestClass = userService.getAllUsers();
        //expected
        Assert.assertEquals(users, usersFromTestClass);
    }
}
