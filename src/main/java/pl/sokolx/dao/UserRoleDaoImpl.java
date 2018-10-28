package pl.sokolx.dao;

import pl.sokolx.api.UserRoleDao;
import pl.sokolx.models.RoleType;
import pl.sokolx.models.UserRole;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRoleDaoImpl implements UserRoleDao {

    static UserRoleDao userRoleDao = new UserRoleDaoImpl();

    private Connection connection;
    private final String databaseName = "management";
    private final String tableName = "user_roles";
    private final String user = "root";
    private final String password = "2nuwb1";

    public UserRoleDaoImpl() {
        init();
    }
    private void init() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/"+databaseName+"?useSSL=false", user, password);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    @Override
    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new LinkedList<UserRole>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("role_id");
                String name = resultSet.getString("role_name");
                userRoles.add(new UserRole(id, RoleType.valueOf(name)));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRoles;
    }

    @Override
    public UserRole getUserRoleById(Integer roleId) {
        Statement statement = null;
        try {
            String query = "select * from " + tableName + " where role_id = '" + roleId + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String role = resultSet.getString("role_name");
                RoleType userRole = RoleType.valueOf(role);
                return new UserRole(roleId, userRole);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getUserRoleIdByName(String roleName) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName + " where role_name = '" + roleName + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("role_id");
                return id;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
