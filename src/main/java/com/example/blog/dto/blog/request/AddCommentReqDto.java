package com.example.blog.dto.blog.request;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("添加评论入参")
public class AddCommentReqDto {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "博客id")
    private String blogId;

    @ApiModelProperty(value = "回复用户id")
    private String replyUserId;

    @ApiModelProperty(value = "回复评论id")
    private String replyId;

    @ApiModelProperty(value = "评论内容")
    private String comment;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
