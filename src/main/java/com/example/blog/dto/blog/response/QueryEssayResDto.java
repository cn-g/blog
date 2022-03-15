package com.example.blog.dto.blog.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@ApiModel("分页查询博客出参类")
public class QueryEssayResDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    private String name;

    @ApiModelProperty(value = "用户头像")
    private String userPicUrl;

    @ApiModelProperty(value = "类目id")
    private String categoryId;

    @ApiModelProperty(value = "博客链接地址")
    private String blogUrl;

    @ApiModelProperty(value = "图片url")
    private String picUrl;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "摘要")
    private String synopsis;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "文章标签,1、发布 2、草稿")
    private Integer label;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "发布时间")
    private LocalDateTime publishTime;

    @ApiModelProperty(value = "评论数")
    private Integer commentNumber;

    @ApiModelProperty(value = "点赞数")
    private Integer goodNumber;

    @ApiModelProperty(value = "收藏数")
    private Integer collectNumber;

    @ApiModelProperty(value = "浏览数")
    private Integer viewNumber;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
