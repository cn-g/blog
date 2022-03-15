package com.example.blog.service.home;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.home.RecommendMapper;
import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.entity.home.Recommend;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Service
public class RecommendService extends ServiceImpl<RecommendMapper, Recommend> {

    /**
     * 添加轮播
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
     * 修改轮播
     * @param reqDto
     * @return
     */
    public Boolean updateRecommend(UpdateRecommendReqDto reqDto){
        Recommend recommend = ToolsUtil.convertType(reqDto,Recommend.class);
        recommend.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(recommend) > 0;
    }

    /**
     * 删除轮播
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
     * 分页查询轮播
     * @param reqDto
     * @return
     */
    public IPage<QueryRecommendResDto> getRecommendPage(QueryRecommendReqDto reqDto){
        LambdaQueryWrapper<Recommend> queryWrapper = new LambdaQueryWrapper<>();
        if(ParamUtil.notEmpty(reqDto.getDay())){
            queryWrapper.eq(Recommend::getDay,reqDto.getDay());
        }
        Page<Recommend> recommendPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(Recommend::getStatus,9));
        return ToolsUtil.convertType(recommendPage,QueryRecommendResDto.class);
    }

    /**
     * 查询轮播
     * @param reqDto
     * @return
     */
    public QueryRecommendResDto getRecommend(IdRequestDto reqDto){
        Recommend recommend = baseMapper.selectById(reqDto.getId());
        return ToolsUtil.convertType(recommend,QueryRecommendResDto.class);
    }

}
