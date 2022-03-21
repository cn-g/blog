package com.example.blog.dto.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel
public class UpdateUrlReqDto {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("接口地址")
    private String url;

    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("状态")
    private Integer status;

}
