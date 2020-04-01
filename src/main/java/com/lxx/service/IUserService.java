package com.lxx.service;

import com.lxx.model.User;

import java.util.Map;

public interface IUserService {

    public boolean checkUser(User user);

    public User getUserByName(Map<String,Object> map);

}
