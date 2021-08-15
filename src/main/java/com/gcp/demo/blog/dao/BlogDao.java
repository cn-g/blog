package com.gcp.demo.blog.dao;


import com.gcp.demo.blog.entity.Blog;
import com.gcp.demo.sort.entity.Sort;
import com.gcp.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BlogDao {
    public int insertblog(Blog blog, User user, Sort sort);
    public List<Blog> selectblog();
    public List<Blog> selectblogBySort(Sort sort);
}
