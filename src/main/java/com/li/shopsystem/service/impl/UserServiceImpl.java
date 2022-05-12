package com.li.shopsystem.service.impl;

import com.li.shopsystem.mapper.UserMapper;
import com.li.shopsystem.pojo.Shop;
import com.li.shopsystem.pojo.User;
import com.li.shopsystem.service.UserService;
import com.li.shopsystem.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.li.shopsystem.utils.Code;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


/**
 * @author Li
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private Code code;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 用户登录业务
     * @param userName 用户名
     * @param passWord  密码
     * @return 执行结果 1为成功，0为失败 -1为报错
     */
    public int userToLogin(String userName, String passWord, HttpSession session){
        if(userName!=null&&passWord!=null){
            if(!userName.equals(" ") && !passWord.equals(" ")){
                User user = userLogin(userName, passWord);
                if(user!=null){
                    session.setAttribute("UserID",user.getUid());
                    session.setAttribute("User",user.getUsername());
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
        return -1;
    }

    /**
     * 用户获取验证码，并添加至redis内存储 验证码有效期为5分钟
     * @param email 用户邮箱
     * @return 执行结果 1为成功，0为失败 -1为报错
     */
    public int getCode(String email){
        try {
            emailService.setFromUSer("hynuacmteam@163.com");
            String co = code.getCode();
            emailService.sendMail(email, "验证码", "您的验证码是：" + co + "请在5分钟内使用！");
            redisUtil.stringsetex(300,email,co);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * 用户注册
     * @param userName 用户名
     * @param passWord 密码
     * @param email 邮箱
     * @param code  验证码
     * @return 执行结果 1为成功，0为失败 -1为报错
     */
    public int toSignUp(String userName,String passWord,String email,String code){
        try{
            String s=redisUtil.stringget(email);
            if(s!=null&&s.equals(code)){
                System.out.println(userName);
                System.out.println(passWord);
                User user = new User();
                user.setUsername(userName);
                user.setPassword(passWord);
                user.setEmail(email);
                user.setGmt_create(new Date());
                user.setGmt_modified(new Date());
                return insertUser(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }


    public void selectShopByUID(HttpSession session, Model model){
        Long uid = (Long)session.getAttribute("UserID");
        System.out.println(uid);
        List<Shop> ss = listSelectShopByUID(uid);
        model.addAttribute("shopss",ss);
        System.out.println(ss);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(Long uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public List<Shop> listSelectShopByUID(Long uid) {
        return userMapper.listSelectShopByUID(uid);
    }

    @Override
    public User userLogin(String userName, String userPWD) {
        return userMapper.userLogin(userName,userPWD);
    }


}
