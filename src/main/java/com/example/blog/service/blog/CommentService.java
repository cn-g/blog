package com.example.blog.service.blog;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.blog.CommentMapper;
import com.example.blog.entity.blog.Comment;
import org.springframework.stereotype.Service;

/**
 * @author Admin
 */
@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment> {
}
