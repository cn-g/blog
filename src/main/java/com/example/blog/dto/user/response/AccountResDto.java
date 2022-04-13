package com.example.blog.dto.user.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gcp.basicproject.base.IdAndNameDto;
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
@ApiModel("查询账号出参类")
public class AccountResDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "头像")
    private String picUrl;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "用户简介")
    private String synopsis;

    @ApiModelProperty(value = "性别：1男2女3未知")
    private Integer sex;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "所在地区")
    private String areaName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "QQ号")
    private String qqNumber;

    @ApiModelProperty(value = "微信号")
    private String weChat;

    @ApiModelProperty(value = "兴趣类目")
    private List<IdAndNameDto> categoryList;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "上次登陆时间")
    private LocalDateTime lastTime;

    @ApiModelProperty("浏览量")
    private Integer viewNumber;

    @ApiModelProperty("用户数")
    private Integer userNumber;

    @ApiModelProperty("博客数")
    private Integer essayNumber;

}
