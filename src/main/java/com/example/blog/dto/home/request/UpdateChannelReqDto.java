package com.example.blog.dto.home.request;

import com.gcp.basicproject.base.IdRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author Admin
 */
@Data
@ApiModel("修改列表图入参类")
public class UpdateChannelReqDto extends IdRequestDto {

    @ApiModelProperty(value = "链接地址")
    private String blogUrl;

    @ApiModelProperty(value = "博客图片")
    private String blogPic;

    @ApiModelProperty(value = "博客标题")
    private String blogTitle;

    @ApiModelProperty(value = "博客描述")
    private String blogDesc;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
