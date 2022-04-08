package com.example.blog.controller.receptionController.role.blog;

import com.example.blog.dto.blog.request.AddCommentReqDto;
import com.example.blog.dto.blog.response.QueryCommentResDto;
import com.example.blog.service.blog.CommentService;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.PageIdReqDto;
import com.gcp.basicproject.base.WebBaseUrl;
import com.gcp.basicproject.response.PageableResponseModelDto;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Admin
 */
@RestController
@Api(value = "前台博客信息接口",tags = "前台博客信息接口")
@RequestMapping(WebBaseUrl.RECEPTION_URL+"/blog")
public class ReceptionBlogController {

    @Resource
    private CommentService commentService;

    @PostMapping("/addComment")
    @ApiOperation("发布评论接口")
    public ResponseModelDto addComment(@RequestBody AddCommentReqDto reqDto){
        reqDto.setUserId(RequestUtil.getUserId());
        if(commentService.addComment(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("发布评论失败");
        }
    }

    @PostMapping("/deleteComment")
    @ApiOperation("发布评论接口")
    public ResponseModelDto deleteComment(@RequestBody IdRequestDto reqDto){
        if(commentService.deleteComment(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除评论失败");
        }
    }


}
