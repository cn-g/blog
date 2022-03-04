package com.example.blog.dao.blog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.blog.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Admin
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
