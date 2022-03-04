package com.example.blog.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.user.Role;
import com.example.blog.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Admin
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
