package com.example.blog.dto.blog.request;

import com.gcp.basicproject.base.AbstractPageableSearchDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Admin
 */
@Data
@ApiModel("关键字类")
public class KeyWordPageReqDto extends AbstractPageableSearchDto {

    private String keyWord;

}
