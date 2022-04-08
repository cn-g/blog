package com.example.blog.controller.receptionController.home;

import com.example.blog.dto.blog.request.KeyWordPageReqDto;
import com.example.blog.dto.blog.response.QueryCommentResDto;
import com.example.blog.dto.blog.response.QueryEssayResDto;
import com.example.blog.dto.blog.response.ReEssayResDto;
import com.example.blog.dto.home.response.*;
import com.example.blog.entity.home.Channel;
import com.example.blog.service.blog.CategoryService;
import com.example.blog.service.blog.CommentService;
import com.example.blog.service.blog.EssayService;
import com.example.blog.service.home.*;
import com.gcp.basicproject.base.IdAndNameDto;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.PageIdReqDto;
import com.gcp.basicproject.base.WebBaseUrl;
import com.gcp.basicproject.response.PageableResponseModelDto;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "前台首页信息接口",tags = "前台首页信息接口")
@RequestMapping(WebBaseUrl.RECEPTION_URL+"/home")
public class ReceptionHomeController {

    @Resource
    private ChannelService channelService;

    @Resource
    private SearchService searchService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private EssayService essayService;

    @Resource
    private RecommendService recommendService;

    @Resource
    private UserRecommendService userRecommendService;

    @Resource
    private CommentService commentService;

    @GetMapping("/getChannelList")
    @ApiOperation("首页轮播图列表接口")
    public ResponseModelDto<List<QueryChannelResDto>> getChannelList(){
        return ResponseModels.ok(channelService.getChannelList());
    }

    @GetMapping("/getSearchList")
    @ApiOperation("顶部热门搜索列表接口")
    public ResponseModelDto<List<QuerySearchResDto>> getSearchList(){
        return ResponseModels.ok(searchService.getSearchList());
    }

    @GetMapping("/getCategory")
    @ApiOperation("首页获取类目接口")
    public ResponseModelDto<List<IdAndNameDto>> getCategory(){
        return ResponseModels.ok(categoryService.getCategoryData());
    }

    @GetMapping("/getEssayPage")
    @ApiOperation("前台分页获取博客列表")
    public PageableResponseModelDto<QueryEssayResDto> getEssayPage(PageIdReqDto idReqDto){
        return ResponseModels.page2ResponseModel(essayService.getEssayPage(idReqDto));
    }

    @GetMapping("/getRecommendList")
    @ApiOperation("前台热门博客榜单接口")
    public ResponseModelDto<List<QueryRecommendResDto>> getRecommendList(){
        return ResponseModels.ok(recommendService.getRecommendList());
    }

    @GetMapping("/getUserRecommendList")
    @ApiOperation("前台热门博主榜单接口")
    public ResponseModelDto<List<QueryUserRecommendResDto>> getUserRecommendList(){
        return ResponseModels.ok(userRecommendService.getUserRecommendList());
    }

    @GetMapping("/searchEssay")
    @ApiOperation("顶部搜索接口")
    public PageableResponseModelDto<ReEssayResDto> getEssayPageByKeyWord(KeyWordPageReqDto reqDto){
        return ResponseModels.page2ResponseModel(essayService.getEssayList(reqDto));
    }

    @GetMapping("/getEssayDec")
    @ApiOperation("博客详情")
    public ResponseModelDto<QueryEssayResDto> getEssayDec(IdRequestDto reqDto){
        return ResponseModels.ok(essayService.getEssay(reqDto));
    }

    @GetMapping("/getCommentPage")
    @ApiOperation("查询博客评论")
    public PageableResponseModelDto<QueryCommentResDto> getCommentPage(PageIdReqDto reqDto){
        return ResponseModels.page2ResponseModel(commentService.getCommentPage(reqDto));
    }

    public ResponseModelDto addFootprint(){

    }
}
