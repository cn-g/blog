package com.example.blog.dto.blog.request;

import com.gcp.basicproject.base.AbstractPageableSearchDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("分页查询博客入参类")
public class QueryEssayReqDto extends AbstractPageableSearchDto {

    @ApiModelProperty(value = "类目id")
    private String categoryId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "文章标签,1、发布 2、草稿")
    private Integer label;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
