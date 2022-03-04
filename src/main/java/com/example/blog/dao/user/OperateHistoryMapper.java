package com.example.blog.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.user.OperateHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Admin
 */
@Mapper
public interface OperateHistoryMapper extends BaseMapper<OperateHistory> {
}
