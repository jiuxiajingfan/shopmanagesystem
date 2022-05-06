package com.li.shopsystem.pojo;

/**
 * @author Li
 * 店铺实体类
 */
public class Shop {
    private Long id;
    private String name;
    private String introduce;

    public Shop() {
    }

    public Shop(Long id, String name, String introduce) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
