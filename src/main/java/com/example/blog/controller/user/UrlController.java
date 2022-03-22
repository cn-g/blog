package com.example.blog.controller.user;

import com.example.blog.dto.user.request.*;
import com.example.blog.dto.user.response.*;
import com.example.blog.service.user.UrlService;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.response.PageableResponseModelDto;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Admin
 */
@RestController
@Api(value = "接口信息接口",tags = "接口信息接口")
@RequestMapping("/url")
@Slf4j
public class UrlController {

    @Resource
    private UrlService urlService;

    @PostMapping("/addUrl")
    @ApiOperation("添加接口路径接口")
    public ResponseModelDto addRole(@RequestBody AddUrlReqDto reqDto){
        if(urlService.addUrl(reqDto)){
            urlService.addUrlRoleToRedis();
            return ResponseModels.ok();
        }else{
            throw new CommonException("添加接口路径失败");
        }
    }

    @PostMapping("/deleteUrl")
    @ApiOperation("删除接口路径接口")
    public ResponseModelDto deleteRole(@RequestBody IdRequestDto reqDto){
        if(urlService.deleteUrl(reqDto)){
            urlService.addUrlRoleToRedis();
            return ResponseModels.ok();
        }else{
            throw new CommonException("删除接口路径失败");
        }
    }

    @GetMapping("/getUrlPage")
    @ApiOperation("分页查询接口路径信息接口")
    public PageableResponseModelDto<QueryUrlResDto> queryRolePage(QueryUrlReqDto reqDto){
        return ResponseModels.page2ResponseModel(urlService.queryUrlPage(reqDto));
    }

    @PostMapping("/updateUrl")
    @ApiOperation("修改接口路径信息")
    public ResponseModelDto updateUrl(@RequestBody UpdateUrlReqDto reqDto){
        if(urlService.updateUrl(reqDto)){
            urlService.addUrlRoleToRedis();
            return ResponseModels.ok();
        }else{
            throw new CommonException("修改接口路径失败");
        }
    }

    @PostMapping("/addUrlRoleToRedis")
    @ApiOperation("保存接口权限到redis")
    public ResponseModelDto addUrlRoleToRedis(){
        urlService.addUrlRoleToRedis();
        return ResponseModels.ok();
    }

}
