package com.example.blog.controller.home;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 */
@RestController
@Api(value = "热门博客信息接口",tags = "热门博客信息接口")
@RequestMapping("/recommend")
public class RecommendController {
}