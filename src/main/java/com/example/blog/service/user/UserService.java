package com.example.blog.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.user.UserMapper;
import com.example.blog.dto.user.request.AddUserReqDto;
import com.example.blog.dto.user.request.QueryUserReqDto;
import com.example.blog.dto.user.response.QueryUserResDto;
import com.example.blog.dto.user.request.UpdateUserReqDto;
import com.example.blog.entity.user.Account;
import com.example.blog.entity.user.User;
import com.gcp.basicproject.base.AbstractPageableSearchDto;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User>{

    /**
     * 添加用户信息
     * @param reqDto
     * @return
     */
    public Boolean addUser(AddUserReqDto reqDto){
        User user = ToolsUtil.convertType(reqDto,User.class);
        user.setId(ToolsUtil.getUUID());
        user.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(user) > 0;
    }

    /**
     * 分页查询用户信息
     * @param reqDto
     * @return
     */
    public IPage<QueryUserResDto> queryUserPage(QueryUserReqDto reqDto){
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class);
        if(ParamUtil.notEmpty(reqDto.getSex())){
            queryWrapper.eq(User::getSex,reqDto.getSex());
        }
        if(ParamUtil.notEmpty(reqDto.getRealName())){
            queryWrapper.like(User::getRealName,reqDto.getRealName());
        }
        Page<User> userPage = baseMapper.selectPage(reqDto.iPageInfo(), queryWrapper.ne(User::getStatus,9).orderByDesc(User::getCreateTime));
        IPage<QueryUserResDto> queryUserResDtoIPage = ToolsUtil.convertType(userPage,QueryUserResDto.class);
        return queryUserResDtoIPage;
    }

    /**
     * 查询用户信息
     * @param idRequestDto
     * @return
     */
    public QueryUserResDto getUser(IdRequestDto idRequestDto){
        User user = baseMapper.selectById(idRequestDto.getId());
        if(ParamUtil.empty(user)){
            throw new CommonException("未查询到该用户");
        }
        return ToolsUtil.convertType(user,QueryUserResDto.class);
    }

    /**
     * 修改用户信息
     * @param reqDto
     * @return
     */
    public Boolean updateUser(UpdateUserReqDto reqDto){
        User user = ToolsUtil.convertType(reqDto,User.class);
        user.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(user) > 0;
    }

    /**
     * 删除用户
     * @param idRequestDto
     * @return
     */
    public Boolean deleteUser(IdRequestDto idRequestDto){
        User user = baseMapper.selectById(idRequestDto.getId());
        if(ParamUtil.empty(user)){
            return true;
        }
        user.setStatus(9);
        user.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(user) > 0;
    }

}
