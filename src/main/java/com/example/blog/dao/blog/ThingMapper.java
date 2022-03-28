package com.example.blog.dao.blog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.dto.blog.response.QueryThingResDto;
import com.example.blog.entity.blog.Thing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Admin
 */
@Mapper
public interface ThingMapper extends BaseMapper<Thing> {

    /**
     * 查询待办
     * @return
     */
    List<QueryThingResDto> getThing();

}
