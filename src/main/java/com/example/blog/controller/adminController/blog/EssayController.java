package com.example.blog.controller.adminController.blog;

import com.example.blog.dto.blog.request.*;
import com.example.blog.dto.blog.response.QueryEssayResDto;
import com.example.blog.service.blog.EssayService;
import com.gcp.basicproject.base.IdAndNameDto;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.WebBaseUrl;
import com.gcp.basicproject.response.PageableResponseModelDto;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Admin
 */
@RestController
@Api(value = "博客信息接口",tags = "博客信息接口")
@RequestMapping(WebBaseUrl.ADMIN_URL+"/essay")
public class EssayController {

    @Resource
    private EssayService essayService;

    @PostMapping("/addEssay")
    @ApiOperation("添加博客接口")
    public ResponseModelDto addEssay(@RequestBody AddEssayReqDto reqDto){
        if(essayService.addEssay(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加博客失败");
        }
    }

    @PostMapping("/updateEssay")
    @ApiOperation("修改博客接口")
    public ResponseModelDto updateEssay(@RequestBody UpdateEssayReqDto reqDto){
        if(essayService.updateEssay(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("修改博客失败");
        }
    }

    @PostMapping("/deleteEssay")
    @ApiOperation("删除博客接口")
    public ResponseModelDto deleteEssay(@RequestBody IdRequestDto reqDto){
        if(essayService.deleteEssay(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除博客失败");
        }
    }

    @GetMapping("/getEssayPage")
    @ApiOperation("分页查询博客接口")
    public PageableResponseModelDto<QueryEssayResDto> getEssayPage(QueryEssayReqDto reqDto){
        return ResponseModels.page2ResponseModel(essayService.getEssayPage(reqDto));
    }

    @GetMapping("/getEssay")
    @ApiOperation("查询博客接口")
    public ResponseModelDto<QueryEssayResDto> getEssay(IdRequestDto reqDto){
        return ResponseModels.ok(essayService.getEssay(reqDto));
    }

    @GetMapping("/getEssayData")
    @ApiOperation("博客下拉接口")
    public ResponseModelDto<List<IdAndNameDto>> getEssayData(String name){
        return ResponseModels.ok(essayService.getEssayData(name));
    }

    @GetMapping("/getEssayRatio")
    @ApiOperation("博客占比接口")
    public ResponseModelDto<List<IdAndNameDto>> getEssayRatio(){
        return ResponseModels.ok(essayService.getEssayRatio());
    }

}
