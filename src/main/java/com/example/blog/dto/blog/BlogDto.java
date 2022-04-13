package com.example.blog.dto.blog;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class BlogDto {

    @ApiModelProperty("博客id")
    private String blogId;

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

    @ApiModelProperty(value = "评论数")
    private Integer commentNumber;

    @ApiModelProperty(value = "点赞数")
    private Integer goodNumber;

    @ApiModelProperty(value = "收藏数")
    private Integer collectNumber;

    @ApiModelProperty(value = "浏览数")
    private Integer viewNumber;

}
