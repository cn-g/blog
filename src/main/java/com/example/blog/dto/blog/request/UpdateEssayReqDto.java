package com.example.blog.dto.blog.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("修改博客入参类")
public class UpdateEssayReqDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "类目id")
    private String categoryId;

    @ApiModelProperty(value = "图片url")
    private String picUrl;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "摘要")
    private String synopsis;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "文章标签,1、发布 2、草稿")
    private Integer label;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
