package com.example.blog.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "blog_user")
@ApiModel(value = "User对象",description = "用户信息表")
public class User {

    @TableId(value = "_id")
    @ApiModelProperty(value = "用户id")
    private String id;

    @TableField(value = "real_name")
    @ApiModelProperty(value = "用户姓名")
    private String realName;

    @TableField(value = "pic_url")
    @ApiModelProperty(value = "头像url")
    private String picUrl;

    @TableField(value = "sex")
    @ApiModelProperty(value = "性别：1男2女3未知")
    private Integer sex;

    @TableField(value = "synopsis")
    @ApiModelProperty(value = "用户简介")
    private String synopsis;

    @TableField(value = "area_name")
    @ApiModelProperty(value = "所在地区")
    private String areaName;

    @TableField(value = "province_code")
    @ApiModelProperty(value = "省代码")
    private Integer provinceCode;

    @TableField(value = "city_code")
    @ApiModelProperty(value = "市代码")
    private Integer cityCode;

    @TableField(value = "area_code")
    @ApiModelProperty(value = "区、县代码")
    private Integer areaCode;

    @TableField(value = "birthday")
    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @TableField(value = "categories")
    @ApiModelProperty(value = "分类id集，用逗号分隔")
    private String categories;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @TableField(value = "status")
    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

    @TableField(value = "native_place")
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

}
