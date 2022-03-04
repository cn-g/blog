package com.example.blog.dto.home.request;

import com.gcp.basicproject.base.AbstractPageableSearchDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("分页查询列表图入参类")
public class QueryChannelReqDto extends AbstractPageableSearchDto {

    @ApiModelProperty(value = "博客标题")
    private String blogTitle;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
