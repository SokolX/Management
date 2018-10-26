package pl.sokolx.dao;
import pl.sokolx.api.UserDao;
import pl.sokolx.models.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private final static UserDao instance = new UserDaoImpl();

    private Connection connection;
    private final String databaseName = "management";
    private final String tableName = "users";
    private final String user = "root";
    private final String password = "admin";

    public UserDaoImpl() {
        init();
    }

    public static UserDao getInstance() {
        return UserDaoImpl.instance;
    }


    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        Statement statement = null;

        try {

            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_login");
                String userPassword = resultSet.getString("user_password");
                String userFirstName = resultSet.getString("user_first_name");
                String userLastName = resultSet.getString("user_last_name");
                User user = new User(id, userName, userPassword, userFirstName, userLastName);
                users.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return users;
    }

    public void createUser(User user) {
        PreparedStatement statement;
        try {
            String query = "insert into " + tableName + " (user_login, user_password, user_first_name, user_last_name) values(?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getUserLogin());
            statement.setString(2, user.getUserPassword());
            statement.setString(3, user.getUserFirstName());
            statement.setString(4, user.getUserLastName());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteUser(String lastName) {
        PreparedStatement statement;
        try {
            String query = "delete from " + tableName + " where last_name=?";

            statement = connection.prepareStatement(query);
            statement.setString(1, lastName);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateUser(User user) {
        PreparedStatement statement;
        try {

            String query = "update " + tableName + " set password = ?, first_name = ?, last_name = ? where user_id =?" ;
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getUserPassword());
            statement.setString(2, user.getUserFirstName());
            statement.setString(3, user.getUserLastName());
            statement.setInt(4, user.getUserId());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
