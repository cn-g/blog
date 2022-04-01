package com.example.blog.controller.adminController.user;

import com.example.blog.dto.user.request.*;
import com.example.blog.dto.user.response.*;
import com.example.blog.service.user.OperateService;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.WebBaseUrl;
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
@Api(value = "操作信息接口",tags = "操作信息接口")
@RequestMapping(WebBaseUrl.ADMIN_URL+"/operate")
public class OperateController {

    @Resource
    private OperateService operateService;

    @PostMapping("/addOperate")
    @ApiOperation("添加操作")
    public ResponseModelDto addOperate(@RequestBody AddOperateReqDto reqDto){
        if(operateService.addOperate(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加失败");
        }
    }

    @PostMapping("/updateOperate")
    @ApiOperation("修改操作")
    public ResponseModelDto updateOperate(@RequestBody UpdateOperateReqDto reqDto){
        if(operateService.updateOperate(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("修改失败");
        }
    }

    @PostMapping("/deleteOperate")
    @ApiOperation("删除操作")
    public ResponseModelDto deleteOperate(@RequestBody IdRequestDto reqDto){
        if(operateService.deleteOperate(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除失败");
        }
    }

    @GetMapping("/getOperatePage")
    @ApiOperation("查询操作")
    public PageableResponseModelDto<QueryOperateResDto> getOperatePage(QueryOperateReqDto reqDto){
        return ResponseModels.page2ResponseModel(operateService.queryOperatePage(reqDto));
    }

}
