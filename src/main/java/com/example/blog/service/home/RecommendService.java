package com.example.blog.service.home;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.home.RecommendMapper;
import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.entity.home.Recommend;
import com.example.blog.enums.BlogStatusEnum;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Service
public class RecommendService extends ServiceImpl<RecommendMapper, Recommend> {

    /**
     * 添加热门博客
     * @param reqDto
     * @return
     */
    public Boolean addRecommend(AddRecommendReqDto reqDto){
        Recommend recommend = ToolsUtil.convertType(reqDto,Recommend.class);
        recommend.setId(ToolsUtil.getUUID());
        recommend.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(recommend) > 0;
    }

    /**
     * 修改热门博客
     * @param reqDto
     * @return
     */
    public Boolean updateRecommend(UpdateRecommendReqDto reqDto){
        Recommend recommend = ToolsUtil.convertType(reqDto,Recommend.class);
        recommend.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(recommend) > 0;
    }

    /**
     * 删除热门博客
     * @param reqDto
     * @return
     */
    public Boolean deleteRecommend(IdRequestDto reqDto){
        Recommend recommend = baseMapper.selectById(reqDto.getId());
        recommend.setStatus(9);
        recommend.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(recommend) > 0;
    }

    /**
     * 分页查询热门博客
     * @param reqDto
     * @return
     */
    public IPage<QueryRecommendResDto> getRecommendPage(QueryRecommendReqDto reqDto){
        LambdaQueryWrapper<Recommend> queryWrapper = new LambdaQueryWrapper<>();
        if(ParamUtil.notEmpty(reqDto.getDay())){
            queryWrapper.eq(Recommend::getDay,reqDto.getDay());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(Recommend::getStatus,reqDto.getStatus());
        }
        Page<Recommend> recommendPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(Recommend::getStatus,9));
        return ToolsUtil.convertType(recommendPage,QueryRecommendResDto.class);
    }

    /**
     * 查询热门博客
     * @param reqDto
     * @return
     */
    public QueryRecommendResDto getRecommend(IdRequestDto reqDto){
        Recommend recommend = baseMapper.selectById(reqDto.getId());
        return ToolsUtil.convertType(recommend,QueryRecommendResDto.class);
    }

    /**
     * 获取热门博客榜单列表
     * @return
     */
    public List<QueryRecommendResDto> getRecommendList(){
        List<Recommend> recommendList = baseMapper.selectList(Wrappers.lambdaQuery(Recommend.class).eq(Recommend::getDay, LocalDate.now())
                .eq(Recommend::getStatus, BlogStatusEnum.ENABLE.getCode())
                .orderByAsc(Recommend::getSort)
                .last("limit 10"));
        return ToolsUtil.convertType(recommendList,QueryRecommendResDto.class);
    }

}
