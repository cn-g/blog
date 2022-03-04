package com.example.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("id和name参数")
public class IdAndNameDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "name")
    private String name;

}
