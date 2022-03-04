package com.example.blog.service.home;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.home.RecommendMapper;
import com.example.blog.entity.home.Recommend;
import org.springframework.stereotype.Service;

/**
 * @author Admin
 */
@Service
public class RecommendService extends ServiceImpl<RecommendMapper, Recommend> {
}
