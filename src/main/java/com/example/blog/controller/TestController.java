package com.example.blog.controller;

import com.example.blog.util.QCloudCosUtils;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author Admin
 */
@RestController
@Api(value = "对象存储接口",tags = "对象存储接口")
@RequestMapping("/cloud")
public class TestController {

    @Resource
    private QCloudCosUtils qCloudCosUtils;

    @ApiOperation(value = "上传图片返回url")
    @PostMapping("/uploadImg")
    public ResponseModelDto<String> uploadImg(@RequestParam("file") File file){
        return ResponseModels.ok(qCloudCosUtils.upload(file));
    }

}
