package com.lxx.dao;

import com.lxx.model.User;
import com.sun.javafx.collections.MappingChange;

import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByName(Map<String,Object> map);
}