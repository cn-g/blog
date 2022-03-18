package com.example.blog.enums;

import lombok.Getter;

/**
 * 文章状态标识
 * @author Admin
 */

@Getter
public enum EssayLabelEnum {

    PUBLISH(1,"发布"),
    DRAFT(2,"草稿");

    private Integer code;

    private String desc;

    EssayLabelEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

}
