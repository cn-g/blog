package com.example.blog.controller.home;

import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.service.home.ChannelService;
import com.gcp.basicproject.base.IdRequestDto;
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
@Api(value = "频道信息接口",tags = "频道信息接口")
@RequestMapping("/channel")
public class ChannelController {

    @Resource
    private ChannelService channelService;

    @PostMapping("/addChannel")
    @ApiOperation("添加轮播图接口")
    public ResponseModelDto addChannel(@RequestBody AddChannelReqDto reqDto){
        if(channelService.addChannel(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加博客失败");
        }
    }

    @PostMapping("/updateChannel")
    @ApiOperation("修改轮播图接口")
    public ResponseModelDto updateChannel(@RequestBody UpdateChannelReqDto reqDto){
        if(channelService.updateChannel(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("修改博客失败");
        }
    }

    @PostMapping("/deleteChannel")
    @ApiOperation("删除轮播图接口")
    public ResponseModelDto deleteChannel(@RequestBody IdRequestDto reqDto){
        if(channelService.deleteChannel(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除博客失败");
        }
    }

    @GetMapping("/getChannelPage")
    @ApiOperation("分页查询轮播图接口")
    public PageableResponseModelDto<QueryChannelResDto> getChannelPage(QueryChannelReqDto reqDto){
        return ResponseModels.page2ResponseModel(channelService.getChannelPage(reqDto));
    }

    @GetMapping("/getChannel")
    @ApiOperation("查询轮播图接口")
    public ResponseModelDto<QueryChannelResDto> getChannel(IdRequestDto reqDto){
        return ResponseModels.ok(channelService.getChannel(reqDto));
    }

}
