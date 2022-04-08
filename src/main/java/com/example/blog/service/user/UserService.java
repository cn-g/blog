package com.example.blog.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.user.UserMapper;
import com.example.blog.dto.home.request.AddUserRecommendReqDto;
import com.example.blog.dto.user.request.*;
import com.example.blog.dto.user.response.*;
import com.example.blog.dto.home.request.*;
import com.example.blog.entity.user.Account;
import com.example.blog.entity.user.User;
import com.example.blog.enums.BlogStatusEnum;
import com.example.blog.service.blog.CategoryService;
import com.example.blog.service.blog.EssayService;
import com.gcp.basicproject.base.AbstractPageableSearchDto;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.util.FastJsonUtil;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Admin
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User>{

    @Resource
    private AccountService accountService;

    @Resource
    private EssayService essayService;

    @Resource
    private CategoryService categoryService;


    /**
     * 添加用户信息
     * @param reqDto
     * @return
     */
    public Boolean addUser(AddUserReqDto reqDto){
        User user = ToolsUtil.convertType(reqDto,User.class);
        if(ParamUtil.notEmpty(baseMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getId,reqDto.getId()).ne(User::getStatus, BlogStatusEnum.DELETE.getCode())))){
            throw new CommonException("该用户已存在");
        }
        if(ParamUtil.notEmpty(reqDto.getCategories())){
            user.setCategories(FastJsonUtil.toJSON(reqDto.getCategories()));
        }
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
        List<QueryUserResDto> queryUserResDtoList = Lists.newArrayList();
        for (User record : userPage.getRecords()) {
            QueryUserResDto queryUserResDto = ToolsUtil.convertType(record,QueryUserResDto.class);
            queryUserResDto.setAccount(accountService.getAccount(new IdRequestDto().setId(record.getId())).getAccount());
            queryUserResDto.setCategories(FastJsonUtil.toList(record.getCategories(),String.class));
            queryUserResDtoList.add(queryUserResDto);
        }
        IPage<QueryUserResDto> queryUserResDtoIPage = ToolsUtil.convertType(userPage,QueryUserResDto.class);
        return queryUserResDtoIPage.setRecords(queryUserResDtoList);
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
        QueryUserResDto queryUserResDto = ToolsUtil.convertType(user,QueryUserResDto.class);
        queryUserResDto.setCategories(FastJsonUtil.toList(user.getCategories(),String.class));
        List<String> nameList = Lists.newArrayList();
        for (String category : queryUserResDto.getCategories()) {
            nameList.add(categoryService.getById(category).getName());
        }
        queryUserResDto.setCategoryName(String.join(",",nameList));
        return queryUserResDto;
    }

    /**
     * 修改用户信息
     * @param reqDto
     * @return
     */
    public Boolean updateUser(UpdateUserReqDto reqDto){
        User user = ToolsUtil.convertType(reqDto,User.class);
        if(ParamUtil.notEmpty(reqDto.getCategories())){
            user.setCategories(FastJsonUtil.toJSON(reqDto.getCategories()));
        }
        if(ParamUtil.empty(baseMapper.selectById(reqDto.getId()))){
            AddUserReqDto addUserReqDto = ToolsUtil.convertType(reqDto,AddUserReqDto.class);
            return addUser(addUserReqDto);
        }
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
        user.setStatus(BlogStatusEnum.DELETE.getCode());
        user.setUpdateTime(LocalDateTime.now());
        return baseMapper.deleteById(user) > 0;
    }

    /**
     * 通过用户id查询用户详情
     * @param userId
     * @return
     */
    public UpdateUserRecommendReqDto getUserRecommendByUserId(String userId){
        AccountResDto accountResDto = accountService.getAccount(new IdRequestDto().setId(userId));
        User user = baseMapper.selectById(userId);
        Integer number = essayService.getViewNumberByUserId(userId);
        return new UpdateUserRecommendReqDto().setBlogUserId(userId)
                .setBlogUserName(accountResDto.getAccount())
                .setBlogUserPic(ParamUtil.notEmpty(user.getPicUrl())?user.getPicUrl():null)
                .setBlogUserDesc(ParamUtil.notEmpty(user.getSynopsis())?user.getSynopsis():null)
                .setPageViews(ParamUtil.notEmpty(number)?number:0);
    }

    public Map<String,User> getUserMap(){
        List<User> userList = baseMapper.selectList(Wrappers.lambdaQuery(User.class).eq(User::getStatus,BlogStatusEnum.ENABLE.getCode()));
        return userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
    }

}
