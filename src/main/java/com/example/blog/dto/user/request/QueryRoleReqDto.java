package com.example.blog.dto.user.request;

import com.gcp.basicproject.base.AbstractPageableSearchDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("查询角色信息入参类")
public class QueryRoleReqDto extends AbstractPageableSearchDto {

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "状态")
    private String status;

}
