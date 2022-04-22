package com.example.blog.dto.blog.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Data
@ApiModel("查询评论出参")
public class QueryCommentResDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    private String name;

    @ApiModelProperty(value = "博客id")
    private String blogId;

    @ApiModelProperty(value = "回复用户id")
    private String replyUserId;

    @ApiModelProperty(value = "回复用户昵称")
    private String replyUserName;

    @ApiModelProperty(value = "回复评论id")
    private String replyId;

    @ApiModelProperty(value = "评论内容")
    private String comment;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "回复评论的内容")
    private List<QueryCommentResDto> childComment;

    @ApiModelProperty(value = "是否展示")
    private Boolean inputShow;

}
