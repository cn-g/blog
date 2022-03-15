package com.example.blog.controller.home;

import com.example.blog.dto.home.request.AddChannelReqDto;
import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.service.home.RecommendService;
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
@Api(value = "热门博客信息接口",tags = "热门博客信息接口")
@RequestMapping("/recommend")
public class RecommendController {

    @Resource
    private RecommendService recommendService;

    @PostMapping("/addRecommend")
    @ApiOperation("添加热门博客接口")
    public ResponseModelDto addRecommend(@RequestBody AddRecommendReqDto reqDto){
        if(recommendService.addRecommend(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加热门博客失败");
        }
    }

    @PostMapping("/updateRecommend")
    @ApiOperation("修改热门博客接口")
    public ResponseModelDto updateRecommend(@RequestBody UpdateRecommendReqDto reqDto){
        if(recommendService.updateRecommend(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("修改热门博客失败");
        }
    }

    @PostMapping("/deleteRecommend")
    @ApiOperation("删除热门博客接口")
    public ResponseModelDto deleteRecommend(@RequestBody IdRequestDto reqDto){
        if(recommendService.deleteRecommend(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除热门博客失败");
        }
    }

    @GetMapping("/getRecommendPage")
    @ApiOperation("分页查询热门博客接口")
    public PageableResponseModelDto<QueryRecommendResDto> getRecommendPage(QueryRecommendReqDto reqDto){
        return ResponseModels.page2ResponseModel(recommendService.getRecommendPage(reqDto));
    }

    @GetMapping("/getRecommend")
    @ApiOperation("查询热门博客接口")
    public ResponseModelDto<QueryRecommendResDto> getRecommend(IdRequestDto reqDto){
        return ResponseModels.ok(recommendService.getRecommend(reqDto));
    }

}
