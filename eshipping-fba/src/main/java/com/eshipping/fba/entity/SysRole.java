package com.eshipping.fba.entity;

import javax.persistence.*;
import java.util.List;
/**
 * 
* @ClassName: SysRole 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2017年12月7日 下午6:16:28 
*
 */
@Entity
public class SysRole {
	/**
	 * // 编号
	 */
    @Id@GeneratedValue
    private Integer id; 
    /**
     * // 角色标识程序中判断使用,如"admin",这个是唯一的:
     */
    @Column(unique =true)
    private String role; 
    /**
     * // 角色描述,UI界面显示使用
     */
    private String description; 
    /**
     * // 是否可用,如果不可用将不会添加给用户
     */
    @Column(name="available")
    private Boolean available = Boolean.FALSE; 

   /**
    *  //角色 -- 权限关系：多对多关系;
    */
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;

   /**
    *  // 用户 - 角色关系定义;
    */
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    /**
     * // 一个角色对应多个用户
     */
    private List<UserInfo> userInfos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}