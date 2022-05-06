package com.li.shopsystem.pojo;

import java.util.Date;

/**
 * @author Li
 * 商品实体类
 */
public class Good {
    private Long id;
    private String name;
    private String gid;
    private Long suid;
    private int in_price;
    private int out_price;
    private int profit;
    private Long number;
    private Date gmt_create;
    private Date gmt_make;
    private Date gmt_overdue;

    public Good() {
    }

    public Good(Long id, String name, String gid, Long suid, int in_price, int out_price, int profit, Long number, Date gmt_create, Date gmt_make, Date gmt_overdue) {
        this.id = id;
        this.name = name;
        this.gid = gid;
        this.suid = suid;
        this.in_price = in_price;
        this.out_price = out_price;
        this.profit = profit;
        this.number = number;
        this.gmt_create = gmt_create;
        this.gmt_make = gmt_make;
        this.gmt_overdue = gmt_overdue;
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

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public Long getSuid() {
        return suid;
    }

    public void setSuid(Long suid) {
        this.suid = suid;
    }

    public int getIn_price() {
        return in_price;
    }

    public void setIn_price(int in_price) {
        this.in_price = in_price;
    }

    public int getOut_price() {
        return out_price;
    }

    public void setOut_price(int out_price) {
        this.out_price = out_price;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_make() {
        return gmt_make;
    }

    public void setGmt_make(Date gmt_make) {
        this.gmt_make = gmt_make;
    }

    public Date getGmt_overdue() {
        return gmt_overdue;
    }

    public void setGmt_overdue(Date gmt_overdue) {
        this.gmt_overdue = gmt_overdue;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gid='" + gid + '\'' +
                ", suid=" + suid +
                ", in_price=" + in_price +
                ", out_price=" + out_price +
                ", profit=" + profit +
                ", number=" + number +
                ", gmt_create=" + gmt_create +
                ", gmt_make=" + gmt_make +
                ", gmt_overdue=" + gmt_overdue +
                '}';
    }
}
