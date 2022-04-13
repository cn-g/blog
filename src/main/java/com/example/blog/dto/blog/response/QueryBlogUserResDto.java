package com.example.blog.dto.blog.response;

import com.example.blog.dto.blog.BlogDto;
import com.gcp.basicproject.base.IdAndNameDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Admin
 */
@Data
@ApiModel("博主信息出参")
public class QueryBlogUserResDto {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    private String name;

    @ApiModelProperty(value = "用户头像")
    private String userPicUrl;

    @ApiModelProperty(value = "性别：1男2女3未知")
    private Integer sex;

    @ApiModelProperty(value = "用户简介")
    private String userSynopsis;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "所在地区")
    private String areaName;

    @ApiModelProperty(value = "点赞数")
    private Integer goodNumber;

    @ApiModelProperty(value = "收藏数")
    private Integer collectNumber;

    @ApiModelProperty(value = "浏览数")
    private Integer viewNumber;

    @ApiModelProperty(value = "兴趣类目")
    private List<IdAndNameDto> categoryList;

    @ApiModelProperty("博客列表")
    private List<BlogDto> essayList;

}
