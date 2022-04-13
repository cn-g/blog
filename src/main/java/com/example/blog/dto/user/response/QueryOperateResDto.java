package com.example.blog.dto.user.response;

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
@ApiModel("分页查询操作出参类")
public class QueryOperateResDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "权限描述")
    private String operateDesc;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

    @ApiModelProperty(value = "操作编号")
    private Integer operateNo;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
