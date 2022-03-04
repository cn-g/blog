package com.example.blog.dto.blog.request;

import com.gcp.basicproject.base.IdRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("修改类目入参类")
public class UpdateCategoryReqDto extends IdRequestDto {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
