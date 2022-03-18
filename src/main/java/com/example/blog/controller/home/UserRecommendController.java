package com.example.blog.controller.home;

import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.service.home.UserRecommendService;
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
@Api(value = "热门博主信息接口",tags = "热门博主信息接口")
@RequestMapping("/userRecommend")
public class UserRecommendController {

    @Resource
    private UserRecommendService userRecommendService;

    @PostMapping("/addUserRecommend")
    @ApiOperation("添加热门博主接口")
    public ResponseModelDto addUserRecommend(@RequestBody AddUserRecommendReqDto reqDto){
        if(userRecommendService.addUserRecommend(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加热门博主失败");
        }
    }

    @PostMapping("/updateUserRecommend")
    @ApiOperation("修改热门博主接口")
    public ResponseModelDto updateUserRecommend(@RequestBody UpdateUserRecommendReqDto reqDto){
        if(userRecommendService.updateUserRecommend(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("修改热门博主失败");
        }
    }

    @PostMapping("/deleteUserRecommend")
    @ApiOperation("删除热门博主接口")
    public ResponseModelDto deleteUserRecommend(@RequestBody IdRequestDto reqDto){
        if(userRecommendService.deleteUserRecommend(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除热门博主失败");
        }
    }

    @GetMapping("/getUserRecommendPage")
    @ApiOperation("分页查询热门博主接口")
    public PageableResponseModelDto<QueryUserRecommendResDto> getUserRecommendPage(QueryRecommendReqDto reqDto){
        return ResponseModels.page2ResponseModel(userRecommendService.getUserRecommendPage(reqDto));
    }

    @GetMapping("/getUserRecommend")
    @ApiOperation("查询热门博主接口")
    public ResponseModelDto<QueryUserRecommendResDto> getUserRecommend(IdRequestDto reqDto){
        return ResponseModels.ok(userRecommendService.getUserRecommend(reqDto));
    }

}
