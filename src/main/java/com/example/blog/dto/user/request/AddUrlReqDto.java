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
@ApiModel("添加接口url入参")
public class AddUrlReqDto {

    @ApiModelProperty("接口地址")
    private String url;

    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("状态")
    private Integer status;

}
