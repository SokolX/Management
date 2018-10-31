package pl.sokolx.api;

import pl.sokolx.models.UserRole;

import java.util.List;

public interface UserRoleDao {

    public List<UserRole> getAllUserRoles();

    public UserRole getUserRoleById(Integer roleId);

    public Integer getUserRoleIdByName(String roleName);

}
