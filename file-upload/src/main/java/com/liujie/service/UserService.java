package com.liujie.service;

import com.liujie.dao.UserDao;
import com.liujie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

//    @Autowired
//    private UserDao userDao;
    public List<User> findAllByAge(int i) {
//        return userDao.findAllByAge(i);
        return null;
    }
}
