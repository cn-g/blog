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
import com.gcp.basicproject.util.RequestUtil;
import com.gcp.basicproject.util.ToolsUtil;
import com.google.common.collect.Lists;
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
        thing.setUserId(RequestUtil.getUserId());
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
        List<Thing> thingList = baseMapper.selectList(Wrappers.lambdaQuery(Thing.class).orderByAsc(Thing::getStatus).orderByDesc(Thing::getCreateTime).eq(Thing::getUserId, RequestUtil.getUserId()).last("limit 10"));
        List<QueryThingResDto> queryThingResDtos = Lists.newArrayList();
        thingList.forEach(t->{
            queryThingResDtos.add(new QueryThingResDto().setThing(t.getThing()).setId(t.getId()).setStatus(!t.getStatus().equals(BlogStatusEnum.ENABLE.getCode())));
        });
        return queryThingResDtos;
    }

    public Boolean updateThing(IdRequestDto reqDto){
        Thing thing = baseMapper.selectById(reqDto.getId());
        if(thing.getStatus().equals(BlogStatusEnum.ENABLE.getCode())){
            thing.setStatus(BlogStatusEnum.DELETE.getCode());
        }else{
            thing.setStatus(BlogStatusEnum.ENABLE.getCode());
        }
        return baseMapper.updateById(thing) > 0;
    }

}
