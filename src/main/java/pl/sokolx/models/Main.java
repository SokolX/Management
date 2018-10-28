package pl.sokolx.models;

import pl.sokolx.api.UserDao;
import pl.sokolx.api.UserRoleDao;
import pl.sokolx.dao.UserDaoImpl;
import pl.sokolx.dao.UserRoleDaoImpl;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static UserRoleDao userRoleDao = new UserRoleDaoImpl();
    static UserDao userDao = new UserDaoImpl();

    public static void main(String[] args) throws IOException {
/*
        User user = new User(1l, "user", "userPassword", "Piotr", "Naziwsko");
        System.out.println(user.toString());

        Product product = new Product(1L, "Testowy", 14.99, 1.5f, "Red", 15, ProductType.PRODUCT);
        System.out.println(product.toString());

        Boots boots = new Boots(2L, "Obuwie testowe", 99.99, 1.00f, "Black", 5, ProductType.BOOTS, 43, false);
        System.out.println(boots.toString());

        Cloth cloth = new Cloth(3L, "Jacket", 199.99, 1.5f, "Blue", 10, ProductType.CLOTH, "S", "Jeans");
        System.out.println(cloth.toString());

        List<Product> products = new ArrayList<Product>();
        products.add(product);
        products.add(boots);
        products.add(cloth);

        for (Product product3 : products) {
            System.out.println("id = " + product3.getProductId() + ", productName: " + product3.getProductName() + "prod=" + product3.getProductType());
        }*/
/*
        System.out.println(userDaoImpl.getAllUsers());
        createUser();
        createUser();
        System.out.println(userDaoImpl.getAllUsers());
        deleteUser();
        System.out.println(userDaoImpl.getAllUsers());
        updateUser();
        System.out.println(userDaoImpl.getAllUsers());

        */

        UserDaoImpl userDaoImpl = new UserDaoImpl();
        createUser();
        System.out.println(userDaoImpl.getAllUsers());
        updateUser();
        System.out.println(userDaoImpl.getAllUsers());
    }


    public static void createUser() {

        String login, firstName, lastName, password, role;


        System.out.println("Type a login: ");
        login = scanner.next();
        System.out.println("Type a password: ");
        password = scanner.next();
        System.out.println("Type a first name: ");
        firstName = scanner.next();
        System.out.println("Type a last name: ");
        lastName = scanner.next();
        System.out.println("Type user role: {USER, ADMIN) ");
        role = scanner.next();
        User newUser = new User(login, password, firstName, lastName, RoleType.valueOf(role));

        userDao.createUser(newUser);
        System.out.println("Utworzono Usera: " + newUser.toString());


    }

    public static void deleteUser() {

        String lastNameToRemove;


        System.out.println("Type a last_name to remove: ");
        lastNameToRemove = scanner.next();
        userDao.deleteUser(lastNameToRemove);
        System.out.println("Remove users about last name: " + lastNameToRemove);

    }
    public static void updateUser() {

        String login, firstName, lastName, password, role;
        Integer id;

        System.out.println("Type id user id to edit: ");
        id = scanner.nextInt();
        System.out.println("Type a new login: ");
        login = scanner.next();
        System.out.println("Type a new password: ");
        password = scanner.next();
        System.out.println("Type a first name: ");
        firstName = scanner.next();
        System.out.println("Type a last name: ");
        lastName = scanner.next();
        System.out.println("Type user role: {USER, ADMIN) ");
        role = scanner.next();

        User newUser = new User(id, login, password, firstName, lastName, RoleType.valueOf(role));

        userDao.updateUser(newUser);
        System.out.println("User changed: " + newUser.toString());


    }

}
