package com.liujie.controller;

import com.liujie.upload.pojo.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Hello world!
 *
 */
@Api(description = "Demo接口")
@RestController
@RequestMapping("/demoController")
public class DemoController {

    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @RequestMapping(value="/createUser",method= RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User user){
//        return new ResObject(HttpStatus.OK.value(), "新增成功.");
        return ResponseEntity.status(HttpStatus.OK.value()).body("新增成功");
    }

    @ApiOperation(value = "修改用户" ,  notes="修改用户")
    @RequestMapping(value="/updateUser",method= RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody User user){
        System.out.println("updateUser:::"+user.toString());
        return ResponseEntity.status(HttpStatus.OK.value()).body("修改成功");
    }

    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/deleteUser",method= RequestMethod.DELETE)
    public ResponseEntity deleteUser(@RequestParam("userId") String userId){
        System.out.println("deleteUser:::"+userId);
        return ResponseEntity.status(HttpStatus.OK.value()).body("删除成功");
    }

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/queryUser",method= RequestMethod.GET)
    public ResponseEntity queryUser(@RequestParam("userId") Integer userId){
        System.out.println("queryUser:::"+userId);
        User user = new User(userId,"中年",1,"张三",34,"mao2080@sina.com");
        return ResponseEntity.status(HttpStatus.OK.value()).body(user);
    }

}
