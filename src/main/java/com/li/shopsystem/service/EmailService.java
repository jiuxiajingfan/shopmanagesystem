package com.li.shopsystem.service;

/**
 * 邮件服务接口
 * @author Li
 */
public interface EmailService {

    /**
     * 发送邮件给某人
     * @param sendUser 邮件接收人
     * @param title 邮件的标题
     * @param body  邮件的内容
     */
    void sendMail(String sendUser, String title, String body);
}
