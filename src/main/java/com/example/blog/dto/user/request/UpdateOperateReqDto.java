package com.example.blog.dto.user.request;

import com.gcp.basicproject.base.IdRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("修改操作入参类")
public class UpdateOperateReqDto extends IdRequestDto {

    @ApiModelProperty(value = "操作名称")
    private String name;

    @ApiModelProperty(value = "操作描述")
    private String operateDesc;

    @ApiModelProperty(value = "状态，0禁用、1启用、9删除")
    private Integer status;

}
