package com.example.blog.entity.blog;

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
@TableName(value = "blog_comment")
@ApiModel(value = "Comment对象",description = "评论表")
public class Comment {

    @TableId(value = "_id")
    @ApiModelProperty(value = "id")
    private String id;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private String userId;

    @TableField(value = "blog_id")
    @ApiModelProperty(value = "博客id")
    private String blogId;

    @TableField(value = "reply_user_id")
    @ApiModelProperty(value = "回复用户id")
    private String replyUserId;

    @TableField(value = "reply_id")
    @ApiModelProperty(value = "回复评论id")
    private String replyId;

    @TableField(value = "comment")
    @ApiModelProperty(value = "评论内容")
    private String comment;

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
