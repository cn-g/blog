package com.example.blog.service.home;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.home.ChannelMapper;
import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.entity.home.Channel;
import com.example.blog.enums.BlogStatusEnum;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Service
public class ChannelService extends ServiceImpl<ChannelMapper, Channel> {

    /**
     * 添加轮播
     * @param reqDto
     * @return
     */
    public Boolean addChannel(AddChannelReqDto reqDto){
        checkChannel(null);
        Channel channel = ToolsUtil.convertType(reqDto,Channel.class);
        channel.setId(ToolsUtil.getUUID());
        channel.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(channel) > 0;
    }

    /**
     * 轮播图启用数量校验
     */
    public void checkChannel(String id){
        List<Channel> channelList = Lists.newArrayList();
        if(ParamUtil.notEmpty(id)){
            channelList = baseMapper.selectList(Wrappers.lambdaQuery(Channel.class).eq(Channel::getStatus, BlogStatusEnum.ENABLE.getCode()).ne(Channel::getId,id));
        }else{
            channelList = baseMapper.selectList(Wrappers.lambdaQuery(Channel.class).eq(Channel::getStatus, BlogStatusEnum.ENABLE.getCode()));
        }
        if(channelList.size()>4){
            throw new CommonException("最多展示四张轮播图，请先禁用之前的轮播图");
        }
    }

    /**
     * 修改轮播
     * @param reqDto
     * @return
     */
    public Boolean updateChannel(UpdateChannelReqDto reqDto){
        if(reqDto.getStatus().equals(BlogStatusEnum.ENABLE.getCode())){
            checkChannel(reqDto.getId());
        }
        Channel channel = ToolsUtil.convertType(reqDto,Channel.class);
        channel.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(channel) > 0;
    }

    /**
     * 删除轮播
     * @param reqDto
     * @return
     */
    public Boolean deleteChannel(IdRequestDto reqDto){
        Channel channel = baseMapper.selectById(reqDto.getId());
        channel.setStatus(9);
        channel.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(channel) > 0;
    }

    /**
     * 分页查询轮播
     * @param reqDto
     * @return
     */
    public IPage<QueryChannelResDto> getChannelPage(QueryChannelReqDto reqDto){
        LambdaQueryWrapper<Channel> queryWrapper = new LambdaQueryWrapper<>();
        if(ParamUtil.notEmpty(reqDto.getBlogTitle())){
            queryWrapper.like(Channel::getBlogTitle,reqDto.getBlogTitle());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(Channel::getStatus,reqDto.getStatus());
        }
        Page<Channel> channelPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(Channel::getStatus,9));
        return ToolsUtil.convertType(channelPage,QueryChannelResDto.class);
    }

    /**
     * 查询轮播
     * @param reqDto
     * @return
     */
    public QueryChannelResDto getChannel(IdRequestDto reqDto){
        Channel channel = baseMapper.selectById(reqDto.getId());
        return ToolsUtil.convertType(channel,QueryChannelResDto.class);
    }


    /**
     * 分页查询轮播
     * @return
     */
    public List<QueryChannelResDto> getChannelList(){
        List<Channel> channelList = baseMapper.selectList(Wrappers.lambdaQuery(Channel.class).eq(Channel::getStatus,1));
        return ToolsUtil.convertType(channelList,QueryChannelResDto.class);
    }


}
