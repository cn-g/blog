package com.example.blog.controller.receptionController.login;

import com.example.blog.dto.user.request.AddAccountReqDto;
import com.example.blog.dto.user.request.LoginBlogReqDto;
import com.example.blog.enums.UserTypeEnum;
import com.example.blog.service.user.AccountService;
import com.gcp.basicproject.base.LoginResponseDto;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/userRegister")
    @ApiOperation("用户注册")
    public ResponseModelDto register(@RequestBody AddAccountReqDto reqDto){
        reqDto.setType(UserTypeEnum.RECEPTION.getCode());
        if(accountService.addAccount(reqDto)){
            return ResponseModels.ok();
        }
        return ResponseModels.commonException("注册失败");
    }


}
