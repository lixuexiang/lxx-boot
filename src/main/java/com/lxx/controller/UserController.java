package com.lxx.controller;

import com.lxx.model.User;
import com.lxx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("checkUser")
    public String checkUser(User user){
        boolean t = userService.checkUser(user);
        return "";
    }

}
