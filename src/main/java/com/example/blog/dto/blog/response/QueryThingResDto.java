package com.example.blog.dto.blog.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Admin
 */
@Data
@ApiModel("查询待办事项")
@Accessors(chain = true)
public class QueryThingResDto {

    @ApiModelProperty("事项描述")
    private String thing;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("状态")
    private Boolean status;
}
