package com.example.blog.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Admin
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
