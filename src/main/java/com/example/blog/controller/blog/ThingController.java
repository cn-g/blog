package com.example.blog.controller.blog;

import com.example.blog.dto.blog.request.AddThingReqDto;
import com.example.blog.dto.blog.response.QueryThingResDto;
import com.example.blog.service.blog.ThingService;
import com.gcp.basicproject.base.IdRequestDto;
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
@Api(value = "待办事项接口",tags = "待办事项接口")
@RequestMapping("/thing")
public class ThingController {

    @Resource
    private ThingService thingService;

    @PostMapping("/addThing")
    @ApiOperation("添加待办事项")
    public ResponseModelDto addThing(@RequestBody AddThingReqDto reqDto){
        if(thingService.addThing(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加失败");
        }
    }

    @PostMapping("/updateThing")
    @ApiOperation("完成待办事项")
    public ResponseModelDto updateThing(@RequestBody IdRequestDto reqDto){
        if(thingService.updateThing(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("完成失败");
        }
    }

    @GetMapping("/getThingList")
    @ApiOperation("待办事项列表")
    public ResponseModelDto<List<QueryThingResDto>> getThingList(){
            return ResponseModels.ok(thingService.getThingList());
    }

}
