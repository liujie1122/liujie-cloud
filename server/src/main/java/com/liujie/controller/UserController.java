package com.liujie.controller;

import com.liujie.enums.ExceptionEnum;
import com.liujie.exception.MyException;
import com.liujie.upload.pojo.user.User;
import com.liujie.service.sql.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(description = "UserController接口")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有的用户" ,  notes="查询所有的用户")
    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @ApiOperation(value = "测试全局异常处理" ,  notes="测试全局异常处理")
    @GetMapping("/test")
    public ResponseEntity test(){
        try{
            int i =1/0;
            return ResponseEntity.status(200).body(userService.findAll());
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
        }
    }

    @ApiOperation(value = "测试" ,  notes="测试")
    @GetMapping("/test1")
    public ResponseEntity test1(){
        try{
            return ResponseEntity.status(200).body(userService.findAll());
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
        }

    }

    @ApiOperation(value = "新建用户" ,  notes="保存用户到数据库，并更新到elasticSearch")
    @PostMapping("/user")
    public ResponseEntity user(@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.save(user));
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ExceptionEnum.SERVER_ERROR);
        }
    }

    @ApiOperation(value = "更新用户" ,  notes="更新用户，并更新到elasticSearch")
    @PutMapping("/user/{id}")
    public ResponseEntity user(@PathVariable(("id")) Integer id,@RequestBody User user){
        try{
            return userService.updateUser(id,user);
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ExceptionEnum.SERVER_ERROR);
        }
    }

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @GetMapping("/user/{id}")
    public ResponseEntity user(@PathVariable(("id")) Integer id){
        try{
            return ResponseEntity.ok(userService.getUser(id));
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ExceptionEnum.SERVER_ERROR);
        }
    }

    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable(("id")) Integer id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok("成功");
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ExceptionEnum.SERVER_ERROR);
        }
    }

}
