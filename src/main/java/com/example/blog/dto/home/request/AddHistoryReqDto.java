package com.example.blog.dto.home.request;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@ApiModel("添加历史记录入参")
public class AddHistoryReqDto {

    @ApiModelProperty(value = "关键词")
    private String keyWord;

    @ApiModelProperty(value = "用户id")
    private String blogUserId;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
