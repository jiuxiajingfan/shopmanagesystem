package com.li.shopsystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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
    private double in_price;
    private double out_price;
    private double profit;
    private Long number;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gmt_create;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gmt_make;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gmt_overdue;

    public Good() {
    }

    public Good(Long id, String name, String gid, Long suid, double in_price, double out_price, double profit, Long number, Date gmt_create, Date gmt_make, Date gmt_overdue) {
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

    public double getIn_price() {
        return in_price;
    }

    public void setIn_price(double in_price) {
        this.in_price = in_price;
    }

    public double getOut_price() {
        return out_price;
    }

    public void setOut_price(double out_price) {
        this.out_price = out_price;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
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
