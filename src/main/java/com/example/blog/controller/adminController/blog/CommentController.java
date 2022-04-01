package com.example.blog.controller.adminController.blog;

import com.gcp.basicproject.base.WebBaseUrl;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 */
@RestController
@Api(value = "评论信息接口",tags = "评论信息接口")
@RequestMapping(WebBaseUrl.ADMIN_URL+"/comment")
public class CommentController {



}
