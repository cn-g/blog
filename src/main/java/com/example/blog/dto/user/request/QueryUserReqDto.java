package com.example.blog.dto.user.request;

import com.gcp.basicproject.base.AbstractPageableSearchDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("分页查询用户入参类")
public class QueryUserReqDto extends AbstractPageableSearchDto {

    @ApiModelProperty(value = "用户姓名")
    private String realName;

    @ApiModelProperty(value = "性别：1男2女3未知")
    private Integer sex;

}
