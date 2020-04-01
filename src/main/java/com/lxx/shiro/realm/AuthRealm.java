package com.lxx.shiro.realm;

import com.lxx.model.User;
import com.lxx.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = authenticationToken.getPrincipal().toString();//token由控制层传入，获取token中存储的用户名
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userName",userName);
        User user = userService.getUserByName(map);//根据用户名去数据库查询是否存在该用户
        if(user == null){
            throw new UnknownAccountException();//用户不存在抛出不存在异常交给控制层处理
        }
        String password = user.getUserPass();
        String salt = user.getSalt();
        //再次把salt转成byte将整个认证交给SecurityManage
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password, ByteSource.Util.bytes(salt),getName());
        return authenticationInfo;
    }
}
