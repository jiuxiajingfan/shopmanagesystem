package com.li.shopsystem.pojo;

/**
 * @author Li
 * 带权限的用户
 */
public class UserRole {
    private User user;
    private Shop shop;
    private String role;

    public UserRole() {
    }

    public UserRole(User user, Shop shop, String role) {
        this.user = user;
        this.shop = shop;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user=" + user +
                ", shop=" + shop +
                ", role='" + role + '\'' +
                '}';
    }
}
