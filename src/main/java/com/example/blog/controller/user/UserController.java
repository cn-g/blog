package com.example.blog.controller.user;

import com.example.blog.dto.user.request.QueryUserReqDto;
import com.example.blog.dto.user.response.QueryUserResDto;
import com.example.blog.dto.user.request.AddUserReqDto;
import com.example.blog.dto.user.request.UpdateUserReqDto;
import com.example.blog.service.user.UserService;
import com.gcp.basicproject.base.AbstractPageableSearchDto;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.response.PageableResponseModelDto;
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
@Api(value = "用户信息接口",tags = "用户信息接口")
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/addUser")
    @ApiOperation("添加用户信息接口")
    public ResponseModelDto addUser(@RequestBody AddUserReqDto reqDto){
        if(userService.addUser(reqDto)){
            return ResponseModels.ok();
        }else{
            throw new CommonException("添加用户失败");
        }
    }

    @PostMapping("/deleteUser")
    @ApiOperation("删除用户信息接口")
    public ResponseModelDto deleteUser(@RequestBody IdRequestDto reqDto){
        if(userService.deleteUser(reqDto)){
            return ResponseModels.ok();
        }else{
            throw new CommonException("删除用户失败");
        }
    }

    @GetMapping("/getUserPage")
    @ApiOperation("分页查询用户信息接口")
    public PageableResponseModelDto<QueryUserResDto> queryUserPage(QueryUserReqDto reqDto){
        return ResponseModels.page2ResponseModel(userService.queryUserPage(reqDto));
    }

    @PostMapping("/updateUser")
    @ApiOperation("修改用户信息")
    public ResponseModelDto updateUser(@RequestBody UpdateUserReqDto reqDto){
        if(userService.updateUser(reqDto)){
            return ResponseModels.ok();
        }else{
            throw new CommonException("修改用户失败");
        }
    }

    @GetMapping("/getUser")
    @ApiOperation("查询用户信息")
    public ResponseModelDto<QueryUserResDto> getUser(IdRequestDto idRequestDto){
        return ResponseModels.ok(userService.getUser(idRequestDto));
    }

}
