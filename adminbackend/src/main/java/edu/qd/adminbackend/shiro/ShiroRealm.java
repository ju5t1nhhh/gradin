package edu.qd.adminbackend.shiro;

import edu.qd.adminbackend.dao.AdminDao;
import edu.qd.adminbackend.dao.PermissionDao;
import edu.qd.adminbackend.dao.RolePermissionDao;
import edu.qd.adminbackend.domain.Admin;
import edu.qd.adminbackend.domain.Permission;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        String loginId = userInfo.getUsername();
        Admin admin = new Admin(loginId,null,0);
        admin = adminDao.selectByDTO(admin,0,1)[0];
        int[] perms = rolePermissionDao.selectPermByRole(admin.getRole());
        Permission permission = new Permission();
        for ( int perm : perms ) {
            permission.setId(perm);
            Permission temp = permissionDao.selectByDTO(permission,0,1)[0];
            if ( temp.getType() == 1 ) continue;
            simpleAuthorizationInfo.addStringPermission(temp.getUrl());
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginId = (String) token.getPrincipal();
        String password = adminDao.getPassword(loginId);
        UserInfo userInfo = new UserInfo(loginId);
        if ( password == null || password.equals("") )
            throw new UnknownAccountException();
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(userInfo, password, ByteSource.Util.bytes(loginId), getName());
        return simpleAuthenticationInfo;
    }
}
