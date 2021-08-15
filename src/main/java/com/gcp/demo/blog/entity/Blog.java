package com.gcp.demo.blog.entity;

import com.gcp.demo.sort.entity.Sort;
import com.gcp.demo.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
//博客详情实体类
public class Blog {
    private int blogid;
    private String blogtitle;
    private String blogtext;
    private String bloghtml;
    private User user;
    private Sort sort;
}
