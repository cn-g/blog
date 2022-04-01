package com.example.blog.controller.adminController.blog;

import com.example.blog.dto.blog.request.*;
import com.example.blog.dto.blog.response.QueryCategoryResDto;
import com.example.blog.service.blog.CategoryService;
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
@Api(value = "类目信息接口",tags = "类目信息接口")
@RequestMapping(WebBaseUrl.ADMIN_URL+"/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    @ApiOperation("添加类目")
    public ResponseModelDto addCategory(@RequestBody AddCategoryReqDto reqDto){
        if(categoryService.addCategory(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("添加类目失败");
        }
    }

    @PostMapping("/updateCategory")
    @ApiOperation("修改类目")
    public ResponseModelDto updateCategory(@RequestBody UpdateCategoryReqDto reqDto){
        if(categoryService.updateCategory(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("修改类目失败");
        }
    }

    @PostMapping("/deleteCategory")
    @ApiOperation("删除类目")
    public ResponseModelDto deleteCategory(@RequestBody IdRequestDto reqDto){
        if(categoryService.deleteCategory(reqDto)){
            return ResponseModels.ok();
        }else{
            return ResponseModels.commonException("删除类目失败");
        }
    }

    @GetMapping("/getCategoryPage")
    @ApiOperation("分页获取类目")
    public PageableResponseModelDto<QueryCategoryResDto> getCategoryPage(QueryCategoryReqDto reqDto){
        return ResponseModels.page2ResponseModel(categoryService.getCategoryPage(reqDto));
    }

    @GetMapping("/getCategoryData")
    @ApiOperation("类目下拉接口")
    public ResponseModelDto<List<IdAndNameDto>> getCategoryData(String name){
        return ResponseModels.ok(categoryService.getCategoryData(name));
    }
}
