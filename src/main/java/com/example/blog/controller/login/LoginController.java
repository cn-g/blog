package com.example.blog.controller.login;

import com.example.blog.dto.user.request.LoginBlogReqDto;
import com.example.blog.service.user.AccountService;
import com.gcp.basicproject.base.LoginReqDto;
import com.gcp.basicproject.base.LoginResponseDto;
import com.gcp.basicproject.response.ResponseModelDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Admin
 */
@RestController
@Api(value = "登录相关接口",tags = "登录相关接口")
@RequestMapping("/login")
public class LoginController {

    @Resource
    private AccountService accountService;

    @GetMapping("/userLogin")
    @ApiOperation("用户登录接口")
    public ResponseModelDto<LoginResponseDto> login(LoginBlogReqDto reqDto){
        return accountService.login(reqDto);
    }




}
