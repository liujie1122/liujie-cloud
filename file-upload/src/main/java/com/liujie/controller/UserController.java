package com.liujie.controller;

import com.liujie.pojo.User;
import com.liujie.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "UserController接口")
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAllByAge")
    public List<User> findAllByAge(){
        return userService.findAllByAge(10);
    }


}
