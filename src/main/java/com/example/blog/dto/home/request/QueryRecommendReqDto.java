package com.example.blog.dto.home.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gcp.basicproject.base.AbstractPageableSearchDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Data
@ApiModel("查询热门博客入参")
public class QueryRecommendReqDto extends AbstractPageableSearchDto {

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @ApiModelProperty(value = "展示日期")
    private LocalDateTime day;

}
