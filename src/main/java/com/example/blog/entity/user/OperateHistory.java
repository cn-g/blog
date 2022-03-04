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
@TableName(value = "blog_operate_history")
@ApiModel(value = "OperateHistory对象",description = "操作历史表")
public class OperateHistory {

    @TableId(value = "_id")
    @ApiModelProperty(value = "id")
    private String id;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private String userId;



    @TableField(value = "blog_id")
    @ApiModelProperty(value = "博客id")
    private String blogId;

    @TableField(value = "operate_id")
    @ApiModelProperty(value = "操作id")
    private String operateId;

    @TableField(value = "status")
    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
