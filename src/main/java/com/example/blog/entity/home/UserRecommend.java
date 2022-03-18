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
@TableName(value = "blog_user_recommend")
@ApiModel(value = "UserRecommend对象",description = "热门博主表")
public class UserRecommend {

    @TableId(value = "_id")
    @ApiModelProperty(value = "id")
    private String id;

    @TableField(value = "blog_user_id")
    @ApiModelProperty(value = "博主id")
    private String blogUserId;

    @TableField(value = "blog_user_name")
    @ApiModelProperty(value = "博主昵称")
    private String blogUserName;

    @TableField(value = "blog_user_pic")
    @ApiModelProperty(value = "博主头像")
    private String blogUserPic;

    @TableField(value = "blog_user_desc")
    @ApiModelProperty(value = "博主描述")
    private String blogUserDesc;

    @TableField(value = "page_views")
    @ApiModelProperty(value = "总浏览量")
    private Integer pageViews;

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
