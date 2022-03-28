package com.example.blog.dao.blog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.blog.Essay;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Admin
 */
@Mapper
public interface EssayMapper extends BaseMapper<Essay> {

    /**
     * 统计博客浏览数
     * @return
     */
    Integer getViewNumber();

    /**
     * 获取发布的博客数
     * @return
     */
    Integer getEssayNumber();

}
