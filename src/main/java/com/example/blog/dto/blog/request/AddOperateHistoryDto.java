package com.example.blog.dto.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("添加用户足迹入参")
public class AddOperateHistoryDto {

    @ApiModelProperty("博客id")
    private String blogId;

    @ApiModelProperty("操作编号")
    private Integer operateNo;

}
