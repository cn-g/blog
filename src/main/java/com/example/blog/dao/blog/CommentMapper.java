package com.example.blog.dao.blog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.blog.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Admin
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
