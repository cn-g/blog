package com.example.blog.entity.home;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "blog_recommend")
@ApiModel(value = "Recommend对象",description = "热门博客表")
public class Recommend {

    @TableId(value = "_id")
    @ApiModelProperty(value = "id")
    private String id;

    @TableField(value = "blog_id")
    @ApiModelProperty(value = "博客id")
    private String blogId;

    @TableField(value = "blog_pic")
    @ApiModelProperty(value = "博客图片")
    private String blogPic;

    @TableField(value = "blog_title")
    @ApiModelProperty(value = "博客标题")
    private String blogTitle;

    @TableField(value = "blog_user_id")
    @ApiModelProperty(value = "博主id")
    private String blogUserId;

    @TableField(value = "blog_user_name")
    @ApiModelProperty(value = "博主昵称")
    private String blogUserName;

    @TableField(value = "blog_user_pic")
    @ApiModelProperty(value = "博主头像")
    private String blogUserPic;

    @TableField(value = "blog_time")
    @ApiModelProperty(value = "博客发布时间")
    private LocalDateTime blogTime;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableField(value = "status")
    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

    @TableField(value = "day")
    @ApiModelProperty(value = "展示日期")
    private LocalDate day;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}
