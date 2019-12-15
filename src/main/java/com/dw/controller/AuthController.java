package com.dw.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dw.controller.common.model.Result;
import com.dw.controller.converter.UserEntityVoConverter;
import com.dw.controller.model.UserVo;
import com.dw.entity.UserEntity;
import com.dw.service.UserService;
import com.dw.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * 【 权限接口 】
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 【 用户注册接口 】
     *
     * @author yangjunxiong
     * @date 2019/12/15 14:05
     * @param vo
     * @return com.dw.controller.common.model.Result
     **/
    @PostMapping("/register")
    public Result registerUser(@RequestBody UserVo vo){
        vo.verify();
        int count = this.userService.count(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getUserName, vo.getUserName()));
        if (count > 0) {
            return Result.error("该账号已被注册!");
        }
        UserEntity user = UserEntityVoConverter.MAPPER.toEntity(vo);
        user.setPassword(bCryptPasswordEncoder.encode(vo.getPassword()));
//        user.setRole("ROLE_ADMIN"); // 分配角色
        boolean save = userService.save(user);
        return save?Result.ok("注册成功").put("date",user):Result.error("注册失败!");
    }

    /**
     * 【 用户登录接口 】
     **/
    //该接口由springSecurity提供
    //url: localhost:1160/deu_web/auth/login
    //请求方式:post
    //入参格式:JSON
    //入参例子:{ "userName":"yjx", "password":"123", "rememberMe":1 }

    /**
     * 【 通过jwt * 获取登录用户信息】
     *
     * @author yangjunxiong
     */
    @GetMapping("current_user")
    public Result getUserInfo() {
        String loginUser = UserUtil.getLoginUser();
        UserEntity one = this.userService.getOne(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getUserName, loginUser));
//        return Result.ok().put("data",loginUser);
        return Result.ok().put("date",one);
    }
}
