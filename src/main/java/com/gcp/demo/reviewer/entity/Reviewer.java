package com.gcp.demo.reviewer.entity;

import com.gcp.demo.blog.entity.Blog;
import com.gcp.demo.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
//评论实体类
public class Reviewer {
    private int rid;
    private User user;
    private Blog blog;
    private String rtext;
    private int rlike;
}
