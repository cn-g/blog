package com.example.blog.controller.receptionController.blog;

import com.gcp.basicproject.base.WebBaseUrl;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "前台博客信息接口",tags = "前台博客信息接口")
@RequestMapping(WebBaseUrl.RECEPTION_URL+"/blog")
public class ReceptionBlogController {



}
