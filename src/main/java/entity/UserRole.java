package entity;

public class UserRole {
    private Integer id;
    private Integer userId;
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
