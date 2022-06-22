package com.blog.blog_server.controller;

import com.blog.blog_server.entity.User;
import com.blog.blog_server.service.UserService;
import com.blog.blog_server.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "创建用户")
    @PostMapping(path = "/users")
    public Result createUser(@RequestBody User user){
          return userService.createUser(user);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping(path = "/users")
    public Result deleteUser(Integer userId){
        return userService.deleteUser(userId);
    }

    @ApiOperation(value = "修改用户资料")
    @PutMapping(path = "/users")
    public Result updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ApiOperation(value = "根据昵称分页查找用户")
    @GetMapping(path = "/users/nickname")
    public Result getUserByNickname(Integer currentPage,Integer pageSize,String nickname){
        return userService.getUserByNickname(currentPage, pageSize, nickname);
    }

    @ApiOperation(value = "根据用户名查找用户")
    @GetMapping(path = "/users/username")
    public Result getUserByUsername(String username){
        return userService.getUserByUsername(username);
    }

    @ApiOperation(value = "根据昵称分页搜索用户")
    @GetMapping(path = "/users/nickname/search")
    public Result getUserLikeNickname(Integer currentPage,Integer pageSize,String nickname){
        return userService.getUserLikeNickname(currentPage, pageSize, nickname);
    }

    @ApiOperation(value = "根据用户名分页搜索用户")
    @GetMapping(path = "/users/username/search")
    public Result getUserLikeUsername(Integer currentPage,Integer pageSize,String username){
        return userService.getUserLikeUsername(currentPage, pageSize, username);
    }

    @ApiOperation(value = "分页查询全部用户")
    @GetMapping(path = "/users/page")
    public Result getAllUsers(Integer currentPage,Integer pageSize){
        return userService.getAllUsers(currentPage,pageSize);
    }

    @ApiOperation(value = "查询个人信息")
    @GetMapping(path = "/users/userInfo")
    public Result getCorrectUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new Result(200,"success",user);
    }

}
