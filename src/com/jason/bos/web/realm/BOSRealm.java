package com.jason.bos.web.realm;

import com.jason.bos.dao.IUserDao;
import com.jason.bos.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class BOSRealm extends AuthorizingRealm{
    /**
     * 权限：与角色相关
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Autowired
    private IUserDao userDao;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //查询数据操作放在realm
        UsernamePasswordToken uptoken= (UsernamePasswordToken) token;
        String username = uptoken.getUsername();
        User user=userDao.findByUaername(username);
        if (user!=null){
            /**
             * Object principal, 把数据库查询的对象
             * Object credentials,证书：写密码自动验证，查询出来的密码
             * String realmName,当前的类名
             */
            //返回AuthenticationInfo对象,【这个对象会自动验证密码】
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
            return info;
        }
        return null;
    }
}
