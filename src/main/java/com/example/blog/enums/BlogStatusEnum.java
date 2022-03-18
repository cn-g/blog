package com.example.blog.enums;

import lombok.Getter;

/**
 * 数据状态标识
 * @author Admin
 */

@Getter
public enum BlogStatusEnum {

    DISABLE(0,"禁用"),
    ENABLE(1,"启用"),
    DELETE(9,"删除");

    private Integer code;

    private String desc;

    BlogStatusEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

}
