package com.example.blog.dto.home.request;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("添加搜索关键字入参类")
public class AddSearchReqDto {

    @ApiModelProperty(value = "关键词")
    private String keyWord;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
