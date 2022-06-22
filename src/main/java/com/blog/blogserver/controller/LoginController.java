package com.blog.blogserver.controller;


import com.blog.blogserver.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class LoginController {


    @ApiOperation(value = "登录失败")
    @GetMapping("/login_error")
    public Result loginError() {
        return new Result(400,"error", "登录失败!");
    }

    @ApiOperation(value = "登录成功")
    @GetMapping("/login_success")
    public Result loginSuccess() {
        return new Result(200,"success", "登录成功!");
    }

    @ApiOperation(value = "尚未登录，请登录")
    @GetMapping("/login_page")
    public Result loginPage() {
        return new Result(401,"error", "尚未登录，请登录!");
    }
    
}
