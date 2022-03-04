package com.example.blog.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.user.OperateHistoryMapper;
import com.example.blog.entity.user.OperateHistory;
import org.springframework.stereotype.Service;

/**
 * @author Admin
 */
@Service
public class OperateHistoryService extends ServiceImpl<OperateHistoryMapper, OperateHistory> {
}
