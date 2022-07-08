package com.li.shopsystem.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易记录类
 */
public class record implements Serializable {
    private int id;
    private Long sid;
    private double money;
    private Date time;
    private String no;

}
