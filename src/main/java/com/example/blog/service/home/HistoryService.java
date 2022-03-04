package com.example.blog.service.home;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.home.HistoryMapper;
import com.example.blog.entity.home.History;
import org.springframework.stereotype.Service;

/**
 * @author Admin
 */
@Service
public class HistoryService extends ServiceImpl<HistoryMapper, History> {
}
