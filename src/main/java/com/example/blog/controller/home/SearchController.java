package com.example.blog.controller.home;

import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.service.home.SearchService;
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
@Api(value = "搜索关键词信息接口",tags = "搜索关键词信息接口")
@RequestMapping("/search")
public class SearchController {

    @Resource
    private SearchService searchService;

    @PostMapping("/addSearch")
    @ApiOperation("添加搜索关键字接口")
    public ResponseModelDto addSearch(@RequestBody AddSearchReqDto reqDto){
        if(searchService.addSearch(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加搜索关键字失败");
        }
    }

    @PostMapping("/updateSearch")
    @ApiOperation("修改搜索关键字接口")
    public ResponseModelDto updateSearch(@RequestBody UpdateSearchReqDto reqDto){
        if(searchService.updateSearch(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("修改搜索关键字失败");
        }
    }

    @PostMapping("/deleteSearch")
    @ApiOperation("删除搜索关键字接口")
    public ResponseModelDto deleteSearch(@RequestBody IdRequestDto reqDto){
        if(searchService.deleteSearch(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除搜索关键字失败");
        }
    }

    @GetMapping("/getSearchPage")
    @ApiOperation("分页查询搜索关键字接口")
    public PageableResponseModelDto<QuerySearchResDto> getSearchPage(QuerySearchReqDto reqDto){
        return ResponseModels.page2ResponseModel(searchService.getSearchPage(reqDto));
    }

    @GetMapping("/getSearch")
    @ApiOperation("查询搜索关键字接口")
    public ResponseModelDto<QuerySearchResDto> getSearch(IdRequestDto reqDto){
        return ResponseModels.ok(searchService.getSearch(reqDto));
    }

}
