package com.liujie.service.sql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.liujie.dao.UserDao;
import com.liujie.enums.ExceptionEnum;
import com.liujie.exception.MyException;
import com.liujie.upload.pojo.user.User;
import com.liujie.upload.pojo.user.UserSearch;
import com.liujie.service.els.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserSearchService userSearchService;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public Iterable<UserSearch> saveAllFromDatabaseToEls(){
        //添加数据
        List<User> allUser = findAll();
        List<UserSearch> list= JSONObject.parseObject(allUser.toString(), new TypeReference<List<UserSearch>>() {
        });
        return userSearchService.saveAll(list);
    }

    @Transactional
    public ResponseEntity updateUser(Integer id, User user) {
        if (id==null){
            throw new MyException(ExceptionEnum.USER_ID_BE_NULL);
         }
        Optional<User> userOptional = userDao.findById(id);
        User oldUser = userOptional.get();
        if (oldUser==null){
            throw new MyException(ExceptionEnum.USER_NOT_FIND);
        }
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setName(user.getName());
        oldUser.setSex(user.getSex());
        oldUser.setType(user.getType());
        UserSearch userSearch = JSONObject.parseObject(JSON.toJSONString(oldUser), new TypeReference<UserSearch>() {
        });
        userSearchService.save(userSearch);
        return ResponseEntity.ok(oldUser);
    }
    @Transactional
    public User save(User user) {
        User user1 = userDao.save(user);
        UserSearch userSearch = JSONObject.parseObject(JSON.toJSONString(user1), new TypeReference<UserSearch>() {
        });
        userSearchService.save(userSearch);
        return user1;
    }

    public User getUser(Integer id) {
        if (id==null){
            throw new MyException(ExceptionEnum.USER_ID_BE_NULL);
        }
        UserSearch userSearch = userSearchService.findById(id);
        if (userSearch==null){
            return null;
        }
        User user = JSONObject.parseObject(JSON.toJSONString(userSearch), new TypeReference<User>() {
        });
        return user;
    }

    public void deleteUser(Integer id) {
        if (id==null){
            throw new MyException(ExceptionEnum.USER_ID_BE_NULL);
        }
        userSearchService.deleteUser(id);
        userDao.deleteById(id);
    }
}
