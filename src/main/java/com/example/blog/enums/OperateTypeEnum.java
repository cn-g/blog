package com.example.blog.enums;

import lombok.Getter;

/**
 * @author Admin
 */

@Getter
public enum OperateTypeEnum {

    BROWSE(0,"浏览"),
    GOOD(1,"点赞"),
    COLLECT(2,"收藏"),
    SEARCH(4,"搜索"),
    COMMENT(3,"评论");

    private Integer code;

    private String desc;

    OperateTypeEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

}
