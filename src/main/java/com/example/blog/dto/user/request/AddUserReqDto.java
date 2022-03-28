package com.example.blog.dto.user.request;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Data
@ApiModel("添加用户信息入参类")
public class AddUserReqDto {

    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "用户姓名")
    private String realName;

    @ApiModelProperty(value = "头像url")
    private String picUrl;

    @ApiModelProperty(value = "性别：1男2女3未知")
    private Integer sex;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "用户简介")
    private String synopsis;

    @ApiModelProperty(value = "所在地区")
    private String areaName;

    @ApiModelProperty(value = "省代码")
    private Integer provinceCode;

    @ApiModelProperty(value = "市代码")
    private Integer cityCode;

    @ApiModelProperty(value = "区、县代码")
    private Integer areaCode;

    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "分类id集，用逗号分隔")
    private List<String> categories;

    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

}
