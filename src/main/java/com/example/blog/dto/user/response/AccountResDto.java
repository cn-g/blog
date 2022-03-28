package com.example.blog.dto.user.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

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

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "QQ号")
    private String qqNumber;

    @ApiModelProperty(value = "微信号")
    private String weChat;

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
