package com.example.blog.enums;

import lombok.Getter;

/**
 * @author 用户类型
 */

@Getter
public enum UserTypeEnum {

    RECEPTION(1,"前台用户"),
    ADMIN(2,"后台用户");

    private Integer code;

    private String desc;

    UserTypeEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
