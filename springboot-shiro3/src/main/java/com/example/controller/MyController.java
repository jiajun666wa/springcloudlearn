package com.example.controller;

import com.example.config.ShiroUtil;
import com.example.pojo.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-13 00:31
 * @version: 1.0
 */
@Slf4j
@Controller
public class MyController {
    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        model.addAttribute("msg","hello Shiro!!!");
        return "index";
    }

    @RequestMapping(value = {"/user/add"})
    public String userAdd(Model model){
        model.addAttribute("msg","add Shiro!!!");
        return "user/add";
    }
    @RequestMapping(value = {"/user/update"})
    public String userUpdate(Model model){
        model.addAttribute("msg","update Shiro!!!");
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String tologin(){
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST )
    public String login(String username,String password, Model model){
        //获取当前用户
        final Subject subject = SecurityUtils.getSubject();

        try {
            //判断用户是否 已经认证通过，如果不通过则需要登录
            if (!subject.isAuthenticated()){
                //封裝用户登录信息
               UsernamePasswordToken token   = new UsernamePasswordToken(username, password);
               token.setRememberMe(true);
               subject.login(token);
            }

            model.addAttribute("msg","欢迎"+username+"使用！");
            return "index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg","用户名不存在！");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg","密码错误！");
            return "login";
        } catch (LockedAccountException lae) {
            model.addAttribute("msg","用户被锁！");
            return "login";
        }

    }

    //如果有错误页面,优先跳转至error.html
    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){

        return "未经授权无法访问";
    }

    //跳转至注册界面
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @Autowired
    UserService userService;
    //注册操作成功后返回首页，注册失败 仍旧在此界面
    @RequestMapping("/register")
    public String register(String username,String password,Model model){
        User user = userService.queryUserByName(username);
        if (user!=null){
            model.addAttribute("msg","用户已存在！");
            return "register";
        }
        user =new User();
        user.setName(username);


        user.setSaltValue(ShiroUtil.createSalt()); //随机获取盐值,下面要使用
        //  1、 user.setPwd(ShiroUtil.saltPassword(password,user.getSaltValue()));
        //2、MD5方法
        Md5Hash  md5Hash = new Md5Hash(password,user.getSaltValue(),1024);
        user.setPwd(md5Hash.toHex());

        //插入数据
        userService.insertUser(user);
        return "index";
    }
    //退出登录后 跳转至login界面
    @RequestMapping(value = "/logout")
    public String logout(){
        final Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Assert.isTrue(!subject.isAuthenticated());
        return "index";
    }

}
