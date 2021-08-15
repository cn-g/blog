package com.gcp.demo.user.dao;

import com.gcp.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper   //映射器接口（Spring BOOT项目可以不写配置文件，即使用默认配置）
@Repository  //组件注解（用于将数据访问层（Dao层）的类标识为spring Bean）
public interface UserDao {
    public int insertUser(User user);
    public List<User> selectAll();
    public User selectByUname(String ucode,String upwd);
    public List<User> selectucode();
    public User selectByUid(int uid);
}
