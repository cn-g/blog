package com.example.blog.service.blog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.blog.CategoryMapper;
import com.example.blog.dto.blog.request.AddCategoryReqDto;
import com.example.blog.dto.blog.request.QueryCategoryReqDto;
import com.example.blog.dto.blog.request.UpdateCategoryReqDto;
import com.example.blog.dto.blog.response.QueryCategoryResDto;
import com.example.blog.entity.blog.Category;
import com.gcp.basicproject.base.IdAndNameDto;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {

    /**
     * 添加类目
     * @param reqDto
     * @return
     */
    public Boolean addCategory(AddCategoryReqDto reqDto){
        Category category = ToolsUtil.convertType(reqDto,Category.class);
        category.setId(ToolsUtil.getUUID());
        category.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(category) > 0;
    }

    /**
     * 修改类目
     * @param reqDto
     * @return
     */
    public Boolean updateCategory(UpdateCategoryReqDto reqDto){
        Category category = ToolsUtil.convertType(reqDto,Category.class);
        category.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(category) > 0;
    }

    /**
     * 删除类目
     * @param reqDto
     * @return
     */
    public Boolean deleteCategory(IdRequestDto reqDto){
        Category category = baseMapper.selectById(reqDto.getId());
        category.setStatus(9);
        return baseMapper.updateById(category) > 0;
    }

    /**
     * 分页查询类目
     * @param reqDto
     * @return
     */
    public IPage<QueryCategoryResDto> getCategoryPage(QueryCategoryReqDto reqDto){
        LambdaQueryWrapper<Category> queryWrapper = Wrappers.lambdaQuery(Category.class);
        if(ParamUtil.notEmpty(reqDto.getName())){
            queryWrapper.like(Category::getName,reqDto.getName());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(Category::getStatus,reqDto.getStatus());
        }
        Page<Category> categoryPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(Category::getStatus,9).orderByAsc(Category::getSort));
        return ToolsUtil.convertType(categoryPage,QueryCategoryResDto.class);
    }

    /**
     * id和name集
     * @return
     */
    public List<IdAndNameDto> getCategoryData(String name){
        LambdaQueryWrapper<Category> queryWrapper = Wrappers.lambdaQuery(Category.class);
        if(ParamUtil.notEmpty(name)){
            queryWrapper.like(Category::getName,name);
        }
        List<Category> categoryList = baseMapper.selectList(queryWrapper.eq(Category::getStatus,1));
        return ToolsUtil.convertType(categoryList,IdAndNameDto.class);
    }

}
