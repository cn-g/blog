package com.example.blog.dto.user.request;

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
@ApiModel("添加操作入参类")
public class AddOperateReqDto {

    @ApiModelProperty(value = "操作名称")
    private String name;

    @ApiModelProperty(value = "操作描述")
    private String operateDesc;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
