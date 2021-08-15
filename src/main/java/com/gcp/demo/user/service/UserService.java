package com.gcp.demo.user.service;

import com.gcp.demo.user.entity.User;

import java.util.List;


public interface UserService {
    public int addUser(User user);
    public List<User> findAll();
    public User findByUname(String ucode,String upwd);
    public String randomNum();
    public User findByUid(int uid);
}
