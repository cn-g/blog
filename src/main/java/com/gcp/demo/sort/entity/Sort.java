package com.gcp.demo.sort.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//博客分类实体类
public class Sort {
    private int sid;
    private String sname;
}
