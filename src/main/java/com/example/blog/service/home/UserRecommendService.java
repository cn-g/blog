package com.example.blog.service.home;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.home.UserRecommendMapper;
import com.example.blog.dto.home.request.AddRecommendReqDto;
import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.entity.home.Recommend;
import com.example.blog.entity.home.UserRecommend;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Service
public class UserRecommendService extends ServiceImpl<UserRecommendMapper, UserRecommend> {

    /**
     * 添加热门博主
     * @param reqDto
     * @return
     */
    public Boolean addUserRecommend(AddUserRecommendReqDto reqDto){
        UserRecommend userRecommend = ToolsUtil.convertType(reqDto,UserRecommend.class);
        userRecommend.setId(ToolsUtil.getUUID());
        userRecommend.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(userRecommend) > 0;
    }

    /**
     * 修改热门博主
     * @param reqDto
     * @return
     */
    public Boolean updateUserRecommend(UpdateUserRecommendReqDto reqDto){
        UserRecommend userRecommend = ToolsUtil.convertType(reqDto,UserRecommend.class);
        userRecommend.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(userRecommend) > 0;
    }

    /**
     * 删除热门博主
     * @param reqDto
     * @return
     */
    public Boolean deleteUserRecommend(IdRequestDto reqDto){
        UserRecommend userRecommend = baseMapper.selectById(reqDto.getId());
        userRecommend.setStatus(9);
        userRecommend.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(userRecommend) > 0;
    }

    /**
     * 分页查询热门博主
     * @param reqDto
     * @return
     */
    public IPage<QueryUserRecommendResDto> getUserRecommendPage(QueryRecommendReqDto reqDto){
        LambdaQueryWrapper<UserRecommend> queryWrapper = new LambdaQueryWrapper<>();
        if(ParamUtil.notEmpty(reqDto.getDay())){
            queryWrapper.eq(UserRecommend::getDay,reqDto.getDay());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(UserRecommend::getStatus,reqDto.getStatus());
        }
        Page<UserRecommend> userRecommendPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(UserRecommend::getStatus,9));
        return ToolsUtil.convertType(userRecommendPage,QueryUserRecommendResDto.class);
    }

    /**
     * 查询热门博主
     * @param reqDto
     * @return
     */
    public QueryUserRecommendResDto getUserRecommend(IdRequestDto reqDto){
        UserRecommend userRecommend = baseMapper.selectById(reqDto.getId());
        return ToolsUtil.convertType(userRecommend,QueryUserRecommendResDto.class);
    }

}
