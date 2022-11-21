package com.article.manager.entity;

public class SystemRole {
    //角色id
    private String roleId;
    //角色name
    private String roleName;
    //
    private String roleDesc;
    private Integer roleState;

    public SystemRole() {
    }

    public SystemRole(String roleId, String roleName, String roleDesc, Integer roleState) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleState = roleState;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleState() {
        return roleState;
    }

    public void setRoleState(Integer roleState) {
        this.roleState = roleState;
    }
}
