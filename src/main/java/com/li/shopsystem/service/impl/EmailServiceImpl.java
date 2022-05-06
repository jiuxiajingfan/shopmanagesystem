package com.li.shopsystem.service.impl;

import com.li.shopsystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 邮件发送类
 * @author Li
 */

@Service
public class EmailServiceImpl implements EmailService {

    private String fromUSer;

    @Autowired
    private JavaMailSender javaMailSender;



    public void setFromUSer(String fromUSer) {
        this.fromUSer = fromUSer;
    }



    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(String sendUser, String title, String body) {

        SimpleMailMessage simpleMailMessage=new  SimpleMailMessage();
        //邮件的发送人
        simpleMailMessage.setFrom(fromUSer);
        //邮件接收人
        simpleMailMessage.setTo(sendUser);
        //邮件的标题
        simpleMailMessage.setSubject(title);
        //邮件的内容
        simpleMailMessage.setText(body);
        //发送邮件
        javaMailSender.send(simpleMailMessage);

    }
}
