package com.example.blog.dto.home.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@ApiModel("查询搜索关键字出参类")
public class QuerySearchResDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "关键词")
    private String keyWord;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}
