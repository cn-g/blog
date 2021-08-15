package com.gcp.demo.blog.service;

import com.gcp.demo.blog.entity.Blog;
import com.gcp.demo.sort.entity.Sort;
import com.gcp.demo.user.entity.User;

import java.util.List;

public interface BlogService {
    public int addBlog(Blog blog, User user, Sort sort);
    public List<Blog> queryAllBlog();
    public List<Blog> queryOneSort(Sort sort);
}
