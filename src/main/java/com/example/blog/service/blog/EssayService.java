package com.example.blog.service.blog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.blog.EssayMapper;
import com.example.blog.dto.StatisticBlogDto;
import com.example.blog.dto.blog.BlogDto;
import com.example.blog.dto.blog.response.QueryBlogUserResDto;
import com.example.blog.dto.blog.response.ReEssayResDto;
import com.example.blog.dto.user.response.AccountResDto;
import com.example.blog.dto.user.response.QueryUserResDto;
import com.example.blog.enums.BlogStatusEnum;
import com.example.blog.enums.EssayLabelEnum;
import com.example.blog.enums.OperateTypeEnum;
import com.example.blog.service.user.UserService;
import com.gcp.basicproject.base.IdAndNameDto;
import com.example.blog.dto.blog.request.*;
import com.example.blog.dto.blog.response.QueryEssayResDto;
import com.example.blog.entity.blog.Essay;
import com.example.blog.entity.user.Account;
import com.example.blog.service.user.AccountService;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.PageIdReqDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.RequestUtil;
import com.gcp.basicproject.util.ToolsUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Admin
 */
@Service
public class EssayService extends ServiceImpl<EssayMapper, Essay> {

    @Resource
    private AccountService accountService;

    @Resource
    private UserService userService;

    @Resource
    private CategoryService categoryService;

    /**
     * 添加博客
     * @param reqDto
     * @return
     */
    public String addEssay(AddEssayReqDto reqDto){
        if(ParamUtil.notEmpty(reqDto.getId())){
            UpdateEssayReqDto updateEssayReqDto = ToolsUtil.convertType(reqDto,UpdateEssayReqDto.class);
            updateEssay(updateEssayReqDto);
            return reqDto.getId();
        }
        String id = ToolsUtil.getUUID();
        Essay essay = ToolsUtil.convertType(reqDto,Essay.class);
        essay.setId(id);
        essay.setCreateTime(LocalDateTime.now());
        if(reqDto.getLabel() == 1){
            essay.setPublishTime(LocalDateTime.now());
        }
        essay.setGoodNumber(0);
        essay.setViewNumber(0);
        essay.setCommentNumber(0);
        essay.setCollectNumber(0);
        baseMapper.insert(essay);
        return id;
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
        IPage<QueryEssayResDto> queryEssayResDtoIPage = ToolsUtil.convertType(essayPage,QueryEssayResDto.class);
        int i = 0;
        for (QueryEssayResDto record : queryEssayResDtoIPage.getRecords()) {
            record.setName(accountService.getAccount(new IdRequestDto().setId(record.getUserId())).getAccount());
            record.setUserPicUrl(userService.getUser(new IdRequestDto().setId(record.getUserId())).getPicUrl());
            queryEssayResDtoIPage.getRecords().set(i,record);
            i++;
        }
        return queryEssayResDtoIPage;
    }

    /**
     * 查询博客
     * @param reqDto
     * @return
     */
    public QueryEssayResDto getEssay(IdRequestDto reqDto){
        Essay essay = baseMapper.selectById(reqDto.getId());
        if(ParamUtil.empty(essay)){
            AccountResDto accountResDto = accountService.getAccount(reqDto);
            if(ParamUtil.empty(accountResDto)){
                throw new CommonException("查询失败");
            }
            QueryEssayResDto queryEssayResDto = new QueryEssayResDto();
            queryEssayResDto.setName(accountResDto.getAccount());
            queryEssayResDto.setSex(accountResDto.getSex());
            queryEssayResDto.setBirthday(accountResDto.getBirthday());
            queryEssayResDto.setAreaName(accountResDto.getAreaName());
            queryEssayResDto.setUserSynopsis(accountResDto.getSynopsis());
            queryEssayResDto.setUserPicUrl(accountResDto.getPicUrl());
            return queryEssayResDto;
        }
        if(!essay.getLabel().equals(EssayLabelEnum.PUBLISH.getCode())){
            throw new CommonException("查询博客失败");
        }
        QueryEssayResDto queryEssayResDto = ToolsUtil.convertType(essay,QueryEssayResDto.class);
        queryEssayResDto.setName(accountService.getAccount(new IdRequestDto().setId(queryEssayResDto.getUserId())).getAccount());
        QueryUserResDto queryUserResDto = userService.getUser(new IdRequestDto().setId(queryEssayResDto.getUserId()));
        queryEssayResDto.setSex(queryUserResDto.getSex());
        queryEssayResDto.setCategoryName(categoryService.getById(queryEssayResDto.getCategoryId()).getName());
        queryEssayResDto.setBirthday(queryUserResDto.getBirthday());
        queryEssayResDto.setAreaName(queryUserResDto.getAreaName());
        queryEssayResDto.setUserSynopsis(queryUserResDto.getSynopsis());
        queryEssayResDto.setUserPicUrl(queryUserResDto.getPicUrl());
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

    public StatisticBlogDto getNumber(){
        StatisticBlogDto statisticBlogDto = new StatisticBlogDto();
        statisticBlogDto.setEssayNumber(baseMapper.getEssayNumber());
        statisticBlogDto.setViewNumber(baseMapper.getViewNumber());
        return statisticBlogDto;
    }

    public List<IdAndNameDto> getEssayRatio(){
        List<Essay> essayList = baseMapper.selectList(Wrappers.lambdaQuery(Essay.class)
                .eq(Essay::getLabel, EssayLabelEnum.PUBLISH.getCode())
                .ne(Essay::getStatus, BlogStatusEnum.DELETE.getCode())
                .last("limit 10"));
        Map<String,List<Essay>> essayMap = essayList.stream().collect(Collectors.groupingBy(Essay::getCategoryId));
        List<IdAndNameDto> idAndNameDtos = Lists.newArrayList();
        int num = essayList.size();
        essayMap.forEach((a,b)->{
            IdAndNameDto idAndNameDto = new IdAndNameDto();
            idAndNameDto.setId(categoryService.getById(a).getName());
            idAndNameDto.setName(BigDecimal.valueOf(b.size()).divide(BigDecimal.valueOf(num),4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)).toString().split("00")[0]);
            idAndNameDtos.add(idAndNameDto);
        });

        return idAndNameDtos;
    }

    /**
     * 前台分页获取博客信息
     * @param reqDto
     * @return
     */
    public IPage<QueryEssayResDto> getEssayPage(PageIdReqDto reqDto){
        LambdaQueryWrapper<Essay> queryWrapper = new LambdaQueryWrapper<>();
        if(ParamUtil.notEmpty(reqDto.getId())){
            queryWrapper.eq(Essay::getCategoryId,reqDto.getId());
        }else{
            if(ParamUtil.notEmpty(RequestUtil.getUserId()) && !"null".equals(RequestUtil.getUserId())){
                QueryUserResDto queryUserResDto = userService.getUser(new IdRequestDto().setId(RequestUtil.getUserId()));
                if(ParamUtil.notEmpty(queryUserResDto.getCategories())){
                    queryWrapper.in(Essay::getCategoryId,queryUserResDto.getCategories());
                }else{
                    queryWrapper.orderByDesc(Essay::getViewNumber);
                }
            }
        }
        Page<Essay> essayPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.eq(Essay::getStatus,BlogStatusEnum.ENABLE.getCode()).eq(Essay::getLabel,EssayLabelEnum.PUBLISH.getCode()));
        IPage<QueryEssayResDto> queryEssayResDtoIPage = ToolsUtil.convertType(essayPage,QueryEssayResDto.class);
        int i = 0;
        for (QueryEssayResDto record : queryEssayResDtoIPage.getRecords()) {
            AccountResDto account = accountService.getAccount(new IdRequestDto().setId(record.getUserId()));
            record.setName(account.getAccount());
            record.setUserPicUrl(account.getPicUrl());
            queryEssayResDtoIPage.getRecords().set(i,record);
            i++;
        }
        return queryEssayResDtoIPage;
    }

    public IPage<ReEssayResDto> getEssayList(KeyWordPageReqDto reqDto){
        return baseMapper.getEssayByKeyWord(reqDto,reqDto.iPageInfo());
    }

    /**
     * 修改博客统计数据
     * @param blogId
     * @param operateNo
     * @param status
     */
    public void updateEssayStatistic(String blogId,Integer operateNo,Boolean status){
        Essay essay = baseMapper.selectOne(Wrappers.lambdaQuery(Essay.class).eq(Essay::getId,blogId).ne(Essay::getStatus,BlogStatusEnum.DELETE.getCode()));
        if(ParamUtil.empty(essay)){
            throw new CommonException("未找到该博客");
        }
        if(operateNo.equals(OperateTypeEnum.BROWSE.getCode())){
            essay.setViewNumber(essay.getViewNumber()+1);
        }else if(operateNo.equals(OperateTypeEnum.GOOD.getCode())){
            essay.setGoodNumber(essay.getGoodNumber()+(status?1:-1));
        }else if(operateNo.equals(OperateTypeEnum.COLLECT.getCode())){
            essay.setCollectNumber(essay.getCollectNumber()+(status?1:-1));
        }else if(operateNo.equals(OperateTypeEnum.COMMENT.getCode())){
            essay.setCommentNumber(essay.getCommentNumber()+(status?1:-1));
        }else{
            throw new CommonException("操作参数错误");
        }
        baseMapper.updateById(essay);
    }

    /**
     * 获取用户发布的博客
     * @param reqDto
     * @return
     */
    public List<BlogDto> getUserEssay(IdRequestDto reqDto){
        List<Essay> essayList = baseMapper.selectList(Wrappers.lambdaQuery(Essay.class).eq(Essay::getUserId,reqDto.getId())
                .eq(Essay::getLabel,EssayLabelEnum.PUBLISH.getCode())
                .eq(Essay::getStatus,BlogStatusEnum.ENABLE.getCode())
                .orderByDesc(Essay::getPublishTime));
        List<BlogDto> blogDtos =  Lists.newArrayList();
        for (Essay essay : essayList) {
            BlogDto blogDto = ToolsUtil.convertType(essay,BlogDto.class);
            blogDto.setBlogId(essay.getId());
            blogDtos.add(blogDto);
        }
        return blogDtos;
    }

}
