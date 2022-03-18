package com.example.blog.service.blog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.blog.EssayMapper;
import com.example.blog.enums.BlogStatusEnum;
import com.example.blog.enums.EssayLabelEnum;
import com.example.blog.service.user.UserService;
import com.gcp.basicproject.base.IdAndNameDto;
import com.example.blog.dto.blog.request.*;
import com.example.blog.dto.blog.response.QueryEssayResDto;
import com.example.blog.entity.blog.Essay;
import com.example.blog.entity.user.Account;
import com.example.blog.service.user.AccountService;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Service
public class EssayService extends ServiceImpl<EssayMapper, Essay> {

    @Resource
    private AccountService accountService;

    @Resource
    private UserService userService;

    /**
     * 添加博客
     * @param reqDto
     * @return
     */
    public Boolean addEssay(AddEssayReqDto reqDto){
        Essay essay = ToolsUtil.convertType(reqDto,Essay.class);
        essay.setId(ToolsUtil.getUUID());
        essay.setCreateTime(LocalDateTime.now());
        if(reqDto.getLabel() == 1){
            essay.setPublishTime(LocalDateTime.now());
        }
        return baseMapper.insert(essay) > 0;
    }

    /**
     * 修改博客
     * @param reqDto
     * @return
     */
    public Boolean updateEssay(UpdateEssayReqDto reqDto){
        Essay essay = ToolsUtil.convertType(reqDto,Essay.class);
        essay.setUpdateTime(LocalDateTime.now());
        if(reqDto.getLabel() == 1){
            essay.setPublishTime(LocalDateTime.now());
        }
        return baseMapper.updateById(essay) > 0;
    }

    /**
     * 删除博客
     * @param reqDto
     * @return
     */
    public Boolean deleteEssay(IdRequestDto reqDto){
        Essay essay = baseMapper.selectById(reqDto.getId());
        essay.setStatus(9);
        essay.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(essay) > 0;
    }

    /**
     * 分页查询博客
     * @param reqDto
     * @return
     */
    public IPage<QueryEssayResDto> getEssayPage(QueryEssayReqDto reqDto){
        LambdaQueryWrapper<Essay> queryWrapper = new LambdaQueryWrapper<>();
        if(ParamUtil.notEmpty(reqDto.getTitle())){
            queryWrapper.like(Essay::getTitle,reqDto.getTitle());
        }
        if(ParamUtil.notEmpty(reqDto.getLabel())){
            queryWrapper.eq(Essay::getLabel,reqDto.getLabel());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(Essay::getStatus,reqDto.getStatus());
        }
        if(ParamUtil.notEmpty(reqDto.getCategoryId())){
            queryWrapper.eq(Essay::getCategoryId,reqDto.getCategoryId());
        }
        Page<Essay> essayPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(Essay::getStatus,9));
        essayPage.getRecords();
        return ToolsUtil.convertType(essayPage,QueryEssayResDto.class);
    }

    /**
     * 查询博客
     * @param reqDto
     * @return
     */
    public QueryEssayResDto getEssay(IdRequestDto reqDto){
        Essay essay = baseMapper.selectById(reqDto.getId());
        QueryEssayResDto queryEssayResDto = ToolsUtil.convertType(essay,QueryEssayResDto.class);
        queryEssayResDto.setName(accountService.getAccount(new IdRequestDto().setId(queryEssayResDto.getUserId())).getAccount());
        queryEssayResDto.setUserPicUrl(userService.getUser(new IdRequestDto().setId(queryEssayResDto.getUserId())).getPicUrl());
        return queryEssayResDto;
    }

    /**
     * id和name集
     * @return
     */
    public List<IdAndNameDto> getEssayData(String name){
        LambdaQueryWrapper<Essay> queryWrapper = new LambdaQueryWrapper<>();
        if(ParamUtil.notEmpty(name)){
            queryWrapper.like(Essay::getTitle,name);
        }
        List<Essay> essayList = baseMapper.selectList(queryWrapper.eq(Essay::getStatus,1).eq(Essay::getLabel,1));
        List<IdAndNameDto> list = Lists.newArrayList();
        essayList.forEach(a->{
            IdAndNameDto idAndNameDto = new IdAndNameDto();
            idAndNameDto.setId(a.getId());
            idAndNameDto.setName(a.getTitle());
            list.add(idAndNameDto);
        });
        return list;
    }

    /**
     * 获取用户的总浏览量
     * @param userId
     * @return
     */
    public Integer getViewNumberByUserId(String userId){
        List<Essay> essayList = baseMapper.selectList(Wrappers.lambdaQuery(Essay.class)
                .eq(Essay::getUserId,userId)
                .eq(Essay::getLabel, EssayLabelEnum.PUBLISH.getCode())
                .ne(Essay::getStatus, BlogStatusEnum.DELETE.getCode()));
        Integer number = 0;
        for (Essay essay : essayList) {
            number = number + essay.getViewNumber();
        }
        return number;
    }

}
