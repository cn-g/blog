package com.gcp.demo.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//用户实体类
public class User {
    private int uid;
    private String uname;
    private String upwd;
    private String usex;
    private Date ubirthday;
    private String uimg;
    private String ucode;
}
