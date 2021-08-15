package com.gcp.demo.user.service;

import com.gcp.demo.user.dao.UserDao;
import com.gcp.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gcp.demo.common.Randomnumber.getrandom;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }
    @Override
    public List<User> findAll(){
        return userDao.selectAll();
    }
    @Override
    public User findByUname(String ucode,String upwd){
        return userDao.selectByUname(ucode,upwd);
    }
    @Override
    public String randomNum(){ //生成与数据库中的账号不重复的账号
        String number = String.valueOf(getrandom());
        List<User> user = userDao.selectAll();
        //判断是否重复
        for (User user1 : user) {
            if( number == user1.getUcode()){
                number = String.valueOf(getrandom());
            }
        }
        return number;
    }

    @Override
    public User findByUid(int uid) {
        return userDao.selectByUid(uid);
    }
}
