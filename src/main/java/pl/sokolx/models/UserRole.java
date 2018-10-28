package pl.sokolx.models;

public class UserRole {

    private int roleId;
    private RoleType roleName;

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
        return "UserRole{" +
                "roleId=" + roleId +
                ", roleName=" + roleName +
                '}';
    }
}
