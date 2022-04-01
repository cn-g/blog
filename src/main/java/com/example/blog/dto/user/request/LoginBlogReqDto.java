package com.example.blog.dto.user.request;

import com.gcp.basicproject.base.LoginReqDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("博客系统登录入参")
public class LoginBlogReqDto extends LoginReqDto {

    @ApiModelProperty("用户类型，1前台用户2后台用户")
    private Integer type;

}
