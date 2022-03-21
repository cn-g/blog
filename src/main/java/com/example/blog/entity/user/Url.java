package com.example.blog.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "blog_url")
@ApiModel(value = "Url对象",description = "接口表")
public class Url {

    @TableId("_id")
    @ApiModelProperty("id")
    private String id;

    @TableField("url")
    @ApiModelProperty("接口地址")
    private String url;

    @TableField("role_id")
    @ApiModelProperty("角色id")
    private String roleId;

    @TableField("create_time")
    @ApiModelProperty("开始时间")
    private LocalDateTime createTime;

    @TableField("status")
    @ApiModelProperty("状态")
    private Integer status;

}
