package com.example.blog.service.home;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.home.ChannelMapper;
import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.entity.home.Channel;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        Channel channel = ToolsUtil.convertType(reqDto,Channel.class);
        channel.setId(ToolsUtil.getUUID());
        channel.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(channel) > 0;
    }

    /**
     * 修改轮播
     * @param reqDto
     * @return
     */
    public Boolean updateChannel(UpdateChannelReqDto reqDto){
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


}
