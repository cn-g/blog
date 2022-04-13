package com.example.blog.controller.receptionController.role.user;

import com.example.blog.dto.home.response.QueryHistoryResDto;
import com.example.blog.dto.user.response.AccountResDto;
import com.example.blog.service.home.HistoryService;
import com.example.blog.service.user.AccountService;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.WebBaseUrl;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Admin
 */
@RestController
@Api(value = "前台我的信息接口(权限管控)",tags = "前台我的信息接口")
@RequestMapping(WebBaseUrl.RECEPTION_URL+"/user")
public class ReceptionUserController {

    @Resource
    private AccountService accountService;

    @Resource
    private HistoryService historyService;

    @GetMapping("/getAccount")
    @ApiOperation("账号详情")
    public ResponseModelDto<AccountResDto> getAccount(IdRequestDto reqDto){
        return ResponseModels.ok(accountService.getAccount(reqDto));
    }

    @GetMapping("/getHistoryList")
    @ApiOperation("顶部历史搜索列表接口")
    public ResponseModelDto<List<QueryHistoryResDto>> getHistoryList(){
        return ResponseModels.ok(historyService.getHistoryList());
    }


}
