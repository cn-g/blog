package com.example.blog.controller.home;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 */
@RestController
@Api(value = "历史信息接口",tags = "历史信息接口")
@RequestMapping("/history")
public class HistoryController {
}
