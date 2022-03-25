package com.example.blog.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gcp.basicproject.util.ToolsUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "blog_account")
@ApiModel(value = "Account对象",description = "账号信息表")
public class Account {

    @TableId(value = "_id")
    @ApiModelProperty(value = "id")
    private String id;

    @TableField(value = "account")
    @ApiModelProperty(value = "账号")
    private String account;

    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色id")
    private String roleId;

    @TableField(value = "password")
    @ApiModelProperty(value = "密码")
    private String password;

    @TableField(value = "phone")
    @ApiModelProperty(value = "手机号")
    private String phone;

    @TableField(value = "qq_number")
    @ApiModelProperty(value = "QQ号")
    private String qqNumber;

    @TableField(value = "we_chat")
    @ApiModelProperty(value = "微信号")
    private String weChat;

    @TableField(value = "status")
    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}
