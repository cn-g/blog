package com.example.blog.dto.user.request;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("添加角色信息入参类")
public class AddRoleReqDto {

    @ApiModelProperty(value = "权限描述")
    private String roleDec;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "状态，0隐藏、1显示、9删除")
    private Integer status;

}
