package com.example.blog.dto.home.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@ApiModel("添加热门榜单入参")
public class AddRecommendReqDto {

    @ApiModelProperty(value = "博客id")
    private String blogId;

    @ApiModelProperty(value = "博客图片")
    private String blogPic;

    @ApiModelProperty(value = "博客标题")
    private String blogTitle;

    @ApiModelProperty(value = "博主id")
    private String blogUserId;

    @ApiModelProperty(value = "博主昵称")
    private String blogUserName;

    @ApiModelProperty(value = "博主头像")
    private String blogUserPic;

    @ApiModelProperty(value = "博客发布时间")
    private LocalDateTime blogTime;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "展示日期")
    private LocalDateTime day;

}
