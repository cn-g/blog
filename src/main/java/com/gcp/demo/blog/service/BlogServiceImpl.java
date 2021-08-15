package com.gcp.demo.blog.service;

import com.gcp.demo.blog.dao.BlogDao;
import com.gcp.demo.blog.entity.Blog;
import com.gcp.demo.sort.entity.Sort;
import com.gcp.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl  implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public int addBlog(Blog blog, User user, Sort sort) {
        return blogDao.insertblog(blog,user,sort);
    }

    @Override
    public List<Blog> queryAllBlog(){
        return blogDao.selectblog();
    }

    @Override
    public List<Blog> queryOneSort(Sort sort){
        return blogDao.selectblogBySort(sort);
    }
}
