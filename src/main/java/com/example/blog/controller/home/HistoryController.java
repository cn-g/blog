package com.example.blog.controller.home;

import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.QueryHistoryResDto;
import com.example.blog.service.home.*;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.response.PageableResponseModelDto;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Admin
 */
@RestController
@Api(value = "历史信息接口",tags = "历史信息接口")
@RequestMapping("/history")
public class HistoryController {

    @Resource
    private HistoryService historyService;

    @PostMapping("/addHistory")
    @ApiOperation("添加搜索关键字接口")
    public ResponseModelDto addHistory(@RequestBody AddHistoryReqDto reqDto){
        if(historyService.addHistory(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加搜索关键字失败");
        }
    }

    @PostMapping("/updateHistory")
    @ApiOperation("修改搜索关键字接口")
    public ResponseModelDto updateHistory(@RequestBody UpdateHistoryReqDto reqDto){
        if(historyService.updateHistory(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("修改搜索关键字失败");
        }
    }

    @PostMapping("/deleteHistory")
    @ApiOperation("删除搜索关键字接口")
    public ResponseModelDto deleteHistory(@RequestBody IdRequestDto reqDto){
        if(historyService.deleteHistory(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除搜索关键字失败");
        }
    }

    @GetMapping("/getHistoryPage")
    @ApiOperation("分页查询搜索关键字接口")
    public PageableResponseModelDto<QueryHistoryResDto> getHistoryPage(QuerySearchReqDto reqDto){
        return ResponseModels.page2ResponseModel(historyService.getHistoryPage(reqDto));
    }

    @GetMapping("/getHistory")
    @ApiOperation("查询搜索关键字接口")
    public ResponseModelDto<QueryHistoryResDto> getHistory(IdRequestDto reqDto){
        return ResponseModels.ok(historyService.getHistory(reqDto));
    }

}
