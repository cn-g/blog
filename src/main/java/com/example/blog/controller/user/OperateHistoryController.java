package com.example.blog.controller.user;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 */
@RestController
@Api(value = "操作历史信息接口",tags = "操作历史信息接口")
@RequestMapping("/operateHistory")
public class OperateHistoryController {
}
