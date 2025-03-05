package pl.sokolx.models;

import pl.sokolx.models.enums.RoleType;

public class UserRole {

    private int roleId;
    private final RoleType roleName;

    public UserRole(int roleId, RoleType roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public UserRole(RoleType roleName) {
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public RoleType getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "roleId=" + roleId +
                ", roleName=" + roleName +
                '}';
    }
}
