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
@TableName(value = "blog_essay")
@ApiModel(value = "Essay对象",description = "博客信息表")
public class Essay {

    @TableId(value = "_id")
    @ApiModelProperty(value = "id")
    private String id;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private String userId;

    @TableField(value = "blog_url")
    @ApiModelProperty(value = "博客链接地址")
    private String blogUrl;

    @TableField(value = "category_id")
    @ApiModelProperty(value = "类目id")
    private String categoryId;

    @TableField(value = "pic_url")
    @ApiModelProperty(value = "图片url")
    private String picUrl;

    @TableField(value = "title")
    @ApiModelProperty(value = "标题")
    private String title;

    @TableField(value = "synopsis")
    @ApiModelProperty(value = "摘要")
    private String synopsis;

    @TableField(value = "content")
    @ApiModelProperty(value = "内容")
    private String content;

    @TableField(value = "publish_time")
    @ApiModelProperty(value = "发布时间")
    private LocalDateTime publishTime;

    @TableField(value = "label")
    @ApiModelProperty(value = "文章标签,1、发布 2、草稿")
    private Integer label;

    @TableField(value = "comment_number")
    @ApiModelProperty(value = "评论数")
    private Integer commentNumber;

    @TableField(value = "good_number")
    @ApiModelProperty(value = "点赞数")
    private Integer goodNumber;

    @TableField(value = "collect_number")
    @ApiModelProperty(value = "收藏数")
    private Integer collectNumber;

    @TableField(value = "view_number")
    @ApiModelProperty(value = "浏览数")
    private Integer viewNumber;

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
