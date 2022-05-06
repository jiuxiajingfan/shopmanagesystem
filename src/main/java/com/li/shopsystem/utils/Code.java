package com.li.shopsystem.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 生成验证码组件
 * @author Li
 */
@Component
public class Code {

    private String code;

    public String getCode(){
        Random random = new Random();
        code="";
        for(int i=0;i<6;i++){
            code+=String.valueOf(random.nextInt(10));
        }
    return code;
    }

}
