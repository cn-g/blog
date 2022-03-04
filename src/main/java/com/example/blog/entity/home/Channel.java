package com.example.blog.entity.home;

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
@TableName(value = "blog_channel")
@ApiModel(value = "Channel对象",description = "频道表")
public class Channel {

    @TableId(value = "_id")
    @ApiModelProperty(value = "id")
    private String id;

    @TableField(value = "blog_url")
    @ApiModelProperty(value = "链接地址")
    private String blogUrl;

    @TableField(value = "blog_pic")
    @ApiModelProperty(value = "博客图片")
    private String blogPic;

    @TableField(value = "blog_title")
    @ApiModelProperty(value = "博客标题")
    private String blogTitle;

    @TableField(value = "blog_desc")
    @ApiModelProperty(value = "博客描述")
    private String blogDesc;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

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
