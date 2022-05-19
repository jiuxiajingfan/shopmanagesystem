package com.li.shopsystem.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 前端查询商品返回的消息类
 * @ClassName GoodsMessage
 * @Author ：Li
 * @Date ：2022/5/17 21:21
 * @Description：
 * @Version: 1.0
 */
public class GoodsMessage implements Serializable {
    int code;
    String msg;
    int count;
    List<Good> data;

    @Override
    public String toString() {
        return "GoodsMessage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCount() {
        return count;
    }

    public List<Good> getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setData(List<Good> data) {
        this.data = data;
    }
}
