package com.example.blog.dto.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("添加待办事项")
public class AddThingReqDto {

    @ApiModelProperty("事项描述")
    private String thing;

}
