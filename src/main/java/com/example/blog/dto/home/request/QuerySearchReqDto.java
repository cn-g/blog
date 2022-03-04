package com.example.blog.dto.home.request;

import com.gcp.basicproject.base.AbstractPageableSearchDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("查询搜索关键字入参")
public class QuerySearchReqDto extends AbstractPageableSearchDto {

    @ApiModelProperty(value = "关键词")
    private String keyWord;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
