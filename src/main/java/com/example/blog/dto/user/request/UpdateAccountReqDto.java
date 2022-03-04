package com.example.blog.dto.user.request;

import com.gcp.basicproject.base.IdRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("修改账号入参类")
public class UpdateAccountReqDto extends IdRequestDto {

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "QQ号")
    private String qqNumber;

    @ApiModelProperty(value = "微信号")
    private String weChat;

}
