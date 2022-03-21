package com.example.blog.dto.user.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@ApiModel("分页查询接口出参")
public class QueryUrlResDto {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("接口地址")
    private String url;

    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("状态")
    private Integer status;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

}
