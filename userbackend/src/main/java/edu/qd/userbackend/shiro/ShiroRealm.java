package edu.qd.userbackend.shiro;

import edu.qd.userbackend.dao.UserDao;
import edu.qd.userbackend.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        User user = null;
        if ( principal.contains("@") )
            user = userDao.selectByEmail(principal);
        else
            user = userDao.selectById(principal);
        if ( user == null )
            throw new UnknownAccountException();
        if ( user.getStatus() == 0 )
            throw new LockedAccountException();
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(user, user.getPwd(), getName());
        return simpleAuthenticationInfo;
    }
}

