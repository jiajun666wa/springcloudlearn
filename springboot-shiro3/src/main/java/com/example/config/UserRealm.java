package com.example.config;

import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-13 00:43
 * @version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    /*
     2、获得授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，
     常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限；

     注意：这个授权如果不加入缓存，是可以多次执行的 如遇到此类标签shiro:hasPermission
      */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权==》doGetAuthorizationInfo");

        Subject subject = SecurityUtils.getSubject();
        String currentUserName = (String) subject.getPrincipal();
        User currentUser = userService.queryUserByName(currentUserName);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //如果没有权限，权限为null，就返回null
       /* if (currentUser.getPerms() == null){
            return null;
        }*/

        //设置权限~从数据库查寻
        info.addStringPermission(currentUser.getPerms());

        /*放入角色和权限,通过数据库查询 */

        Set<String> roles = new HashSet<String>(); //userService.searchRolesByName();
        roles.add("admin");
        roles.add("user");
        Set<String> permissions =new HashSet<String>(); //userService.searchPermissionsByName();

        permissions.add("user:add");
        permissions.add("user:update");
        info.setRoles(roles);
        info.setStringPermissions(permissions);

        return info;
    }


    //1、身份认证/登录，验证用户是不是拥有相应的身份
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("执行认证==》AuthenticationInfo");
        //1、连接真实的数据库
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user = userService.queryUserByName(userToken.getUsername());
        if(user == null){
            throw new UnknownAccountException();
        }
        //加盐值计算密码，并认证 （此步骤return后会处理） 构造一个principalCollection，供授权使用，由shiro做~ 为了防止密码泄露  第4个参数是realm名称
        final SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(user.getName(), user.getPwd(),
                        new MyByteSource(user.getSaltValue()), this.getName());

        Subject subject = SecurityUtils.getSubject();
        final Session session = subject.getSession();
        session.setAttribute("currentUser",user.getName());

       return authenticationInfo;

    }


}

