package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 *
 * @Author : eden 2020-10-07 15:58
 */
@RestController
@RequestMapping("user")
@CrossOrigin
@Api("用户管理")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        User result = userService.login(user);
        if (result != null) {
            return new Result(true, StatusCode.OK, "登录成功", result);
        }
        return new Result(false, StatusCode.OK, "登录失败");
    }

    @GetMapping("{userId}")
    public Result selectById(@PathVariable String userId) {
        User user = userService.selectById(userId);
        return new Result(true, StatusCode.OK, "查询成功", user);
    }
}
