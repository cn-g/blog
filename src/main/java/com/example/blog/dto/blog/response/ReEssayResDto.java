package com.example.blog.dto.blog.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("前台搜索博客出参类")
public class ReEssayResDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户昵称")
    private String name;

    @ApiModelProperty(value = "用户头像")
    private String userPicUrl;

    @ApiModelProperty(value = "图片url")
    private String picUrl;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "摘要")
    private String synopsis;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "发布时间")
    private LocalDateTime publishTime;

    @ApiModelProperty(value = "点赞数")
    private Integer goodNumber;

    @ApiModelProperty(value = "收藏数")
    private Integer collectNumber;

    @ApiModelProperty(value = "浏览数")
    private Integer viewNumber;

}
