package com.example.blog.dto.user.request;

import com.gcp.basicproject.base.AbstractPageableSearchDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("分页操作入参类")
public class QueryOperateReqDto extends AbstractPageableSearchDto {

    @ApiModelProperty(value = "操作名称")
    private String name;

    @ApiModelProperty(value = "操作描述")
    private String operateDesc;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;
}
