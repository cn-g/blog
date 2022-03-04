package com.example.blog.controller.user;

import com.example.blog.dto.IdAndNameDto;
import com.example.blog.dto.user.request.AddAccountReqDto;
import com.example.blog.dto.user.request.QueryAccountReqDto;
import com.example.blog.dto.user.request.UpdateAccountReqDto;
import com.example.blog.dto.user.response.AccountResDto;
import com.example.blog.dto.user.response.QueryAccountResDto;
import com.example.blog.service.user.AccountService;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.response.PageableResponseModelDto;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import com.github.xiaoymin.knife4j.spring.plugin.OperationDynamicResponseModelProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Admin
 */
@RestController
@Api(value = "账号信息接口",tags = "账号信息接口")
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/addAccount")
    @ApiOperation("添加账号")
    public ResponseModelDto addAccount(@RequestBody AddAccountReqDto reqDto){
        if(accountService.addAccount(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加失败");
        }
    }

    @PostMapping("/updateAccount")
    @ApiOperation("修改账号")
    public ResponseModelDto updateAccount(@RequestBody UpdateAccountReqDto reqDto){
        if(accountService.updateAccount(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("修改失败");
        }
    }

    @PostMapping("/deleteAccount")
    @ApiOperation("删除账号")
    public ResponseModelDto deleteAccount(@RequestBody IdRequestDto reqDto){
        if(accountService.deleteAccount(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除失败");
        }
    }

    @GetMapping("/getAccount")
    @ApiOperation("账号详情")
    public ResponseModelDto<AccountResDto> getAccount(IdRequestDto reqDto){
        return ResponseModels.ok(accountService.getAccount(reqDto));
    }

    @GetMapping("/getAccountPage")
    @ApiOperation("查询账号")
    public PageableResponseModelDto<QueryAccountResDto> getAccountPage(QueryAccountReqDto reqDto){
        return ResponseModels.page2ResponseModel(accountService.getAccountPage(reqDto));
    }

    @GetMapping("/getAccountData")
    @ApiOperation("类目下拉接口")
    public ResponseModelDto<List<IdAndNameDto>> getCategoryData(){
        return ResponseModels.ok(accountService.getAccountData());
    }

}
