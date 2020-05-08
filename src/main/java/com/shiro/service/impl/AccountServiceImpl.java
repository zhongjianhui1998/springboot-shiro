package com.shiro.service.impl;

import com.shiro.dao.AccountDao;
import com.shiro.entity.Role;
import com.shiro.entity.User;
import com.shiro.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**

 * @Description

 * @Author 钟建辉

 * @date  2020/5/8 11:23

 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountDao accountDao;


    /**

     * @Description 根据用户名查找用户信息

     * @Author 钟建辉

     * @Date 2020/5/8 11:23

     * @param username

     * @return com.shiro.entity.User

     **/
    @Override
    public User findUserByUsername(String username) {
        return accountDao.findUserByUsername(username);
    }

    @Override
    public List<Role> findRoleByUserId(int id) {
        return accountDao.findRoleByUserId(id);
    }

    @Override
    public List<com.shiro.entity.Resource> findResourceByUserId(int id) {
        return accountDao.findResourceByUserId(id);
    }

    public boolean login(User user){
//        获取当前用户对象subject
        Subject subject = SecurityUtils.getSubject();
        System.out.println("subject:" + subject.toString());
//        创建用户名/密码身份证验证Token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        System.out.println("token" + token);
        try {
            subject.login(token);
            System.out.println("登录成功");
            subject.hasRole(user.getUsername());
            return true;
        } catch (Exception e) {
            System.out.println("登录失败" + e);
            return false;
        }
    }
}
