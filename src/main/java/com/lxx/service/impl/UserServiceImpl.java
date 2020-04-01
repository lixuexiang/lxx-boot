package com.lxx.service.impl;

import com.lxx.dao.UserMapper;
import com.lxx.model.User;
import com.lxx.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean checkUser(User user) {
        User u = userMapper.selectByPrimaryKey(user.getId());
        return u != null;
    }

    @Override
    public User getUserByName(Map<String,Object> map) {
        User u = userMapper.getUserByName(map);
        return u;
    }
}
