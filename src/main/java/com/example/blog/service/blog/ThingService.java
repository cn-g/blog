package com.example.blog.service.blog;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.blog.EssayMapper;
import com.example.blog.dao.blog.ThingMapper;
import com.example.blog.dto.blog.request.AddThingReqDto;
import com.example.blog.dto.blog.response.QueryThingResDto;
import com.example.blog.entity.blog.Essay;
import com.example.blog.entity.blog.Thing;
import com.example.blog.enums.BlogStatusEnum;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Service
public class ThingService extends ServiceImpl<ThingMapper, Thing> {

    public Boolean addThing(AddThingReqDto reqDto){
        checkThing();
        Thing thing = ToolsUtil.convertType(reqDto,Thing.class);
        thing.setId(ToolsUtil.getUUID());
        thing.setStatus(1);
        thing.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(thing) > 0;
    }

    public void checkThing(){
        List<Thing> things = baseMapper.selectList(Wrappers.lambdaQuery(Thing.class).eq(Thing::getStatus, BlogStatusEnum.ENABLE.getCode()));
        if(things.size() >= 6){
            throw new CommonException("请先将之前的事项完成");
        }
    }

    /**
     * 查询待办事项列表
     * @return
     */
    public List<QueryThingResDto> getThingList(){
        return baseMapper.getThing();
    }

    public Boolean updateThing(IdRequestDto reqDto){
        Thing thing = baseMapper.selectById(reqDto.getId());
        thing.setStatus(9);
        return baseMapper.updateById(thing) > 0;
    }

}
