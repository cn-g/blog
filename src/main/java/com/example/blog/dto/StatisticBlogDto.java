package com.example.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("统计数")
public class StatisticBlogDto {

    @ApiModelProperty("浏览量")
    private Integer viewNumber;

    @ApiModelProperty("用户数")
    private Integer userNumber;

    @ApiModelProperty("博客数")
    private Integer essayNumber;

}
