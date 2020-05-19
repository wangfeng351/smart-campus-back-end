package com.niit.soft.smart.campus.config.shiro;

import com.niit.soft.smart.campus.model.entity.Permission;
import com.niit.soft.smart.campus.model.entity.RolePermission;
import com.niit.soft.smart.campus.model.entity.SysUser;
import com.niit.soft.smart.campus.repository.RolePermissionRepository;
import com.niit.soft.smart.campus.repository.SysUserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/19
 * @Version 1.0
 */
public class CustomRealm extends AuthorizingRealm {
    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private RolePermissionRepository rolePermissionRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        SysUser user = sysUserRepository.findBySysUserName(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        System.out.println("角色id" + user.getRoleId());
        List<Permission> list = rolePermissionRepository.getByRoleId(user.getRoleId());
        Set<String> stringSet = new HashSet<>();
        list.forEach(permission -> {
            stringSet.add(permission.getName());
        });
        info.setStringPermissions(stringSet);
        return info;
    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        System.out.println(userName);
        System.out.println(userPwd);
        SysUser user = sysUserRepository.findBySysUserName(userName);
        if (user == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(user.getPassword())) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(user.getSysUserName(), user.getPassword(), getName());
    }
}
