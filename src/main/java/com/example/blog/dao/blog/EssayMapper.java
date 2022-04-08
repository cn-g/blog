package com.example.blog.dao.blog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.blog.request.KeyWordPageReqDto;
import com.example.blog.dto.blog.response.QueryEssayResDto;
import com.example.blog.dto.blog.response.ReEssayResDto;
import com.example.blog.entity.blog.Essay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    Page<ReEssayResDto> getEssayByKeyWord(@Param("dto") KeyWordPageReqDto reqDto, @Param("page") Page page);

}
