package com.example.blog.dto.home.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@ApiModel("修改热门博客入参")
@Accessors(chain = true)
public class UpdateUserRecommendReqDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "博主id")
    private String blogUserId;

    @ApiModelProperty(value = "博主昵称")
    private String blogUserName;

    @ApiModelProperty(value = "博主头像")
    private String blogUserPic;

    @ApiModelProperty(value = "博主描述")
    private String blogUserDesc;

    @ApiModelProperty(value = "总浏览量")
    private Integer pageViews;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "展示日期")
    private LocalDate day;

}
