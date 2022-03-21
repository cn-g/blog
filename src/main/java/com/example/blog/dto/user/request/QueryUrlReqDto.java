package com.example.blog.dto.user.request;

import com.gcp.basicproject.base.AbstractPageableSearchDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("查询接口url入参")
public class QueryUrlReqDto extends AbstractPageableSearchDto {

    @ApiModelProperty("接口地址")
    private String url;

    @ApiModelProperty("状态")
    private Integer status;

}
