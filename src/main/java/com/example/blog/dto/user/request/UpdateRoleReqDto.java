package com.example.blog.dto.user.request;

import com.gcp.basicproject.base.IdRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("修改角色入参类")
public class UpdateRoleReqDto extends IdRequestDto {

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "权限描述")
    private String roleDec;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
