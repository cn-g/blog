package com.example.blog.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.user.AccountMapper;
import com.example.blog.dto.user.request.*;
import com.example.blog.dto.user.response.*;
import com.example.blog.entity.user.Account;
import com.example.blog.enums.BlogStatusEnum;
import com.gcp.basicproject.base.IdAndNameDto;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.LoginReqDto;
import com.gcp.basicproject.base.LoginResponseDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.RedisUtil;
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
public class AccountService extends ServiceImpl<AccountMapper, Account> {

    private static final String key = "cache_token_";

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 添加账号
     * @param reqDto
     * @return
     */
    public Boolean addAccount(AddAccountReqDto reqDto){
        checkUser(reqDto.getAccount(),"");
        Account account = ToolsUtil.convertType(reqDto,Account.class);
        account.setId(ToolsUtil.getUUID());
        account.setCreateTime(LocalDateTime.now());
        account.setRoleName(roleService.getRole(reqDto.getRoleId()).getName());
        account.setPassword(ToolsUtil.getPasswordToMD5(reqDto.getPassword()));
        account.setStatus(1);
        return baseMapper.insert(account) > 0;
    }

    /**
     * 修改账号
     * @param reqDto
     * @return
     */
    public Boolean updateAccount(UpdateAccountReqDto reqDto){
        checkUser(reqDto.getAccount(),reqDto.getId());
        Account account = ToolsUtil.convertType(reqDto,Account.class);
        account.setRoleName(roleService.getRole(reqDto.getRoleId()).getName());
        account.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(account) > 0;
    }

    /**
     * 删除账号
     * @param reqDto
     * @return
     */
    public Boolean deleteAccount(IdRequestDto reqDto){
        Account account = baseMapper.selectById(reqDto.getId());
        account.setStatus(9);
        account.setUpdateTime(LocalDateTime.now());
        userService.deleteUser(reqDto);
        return baseMapper.updateById(account) > 0;
    }

    /**
     * 查询账号详情
     * @param reqDto
     * @return
     */
    public AccountResDto getAccount(IdRequestDto reqDto){
        AccountResDto accountResDto = ToolsUtil.convertType(baseMapper.selectById(reqDto.getId()),AccountResDto.class);
        return accountResDto;
    }

    /**
     * 分页查询账号
     * @param reqDto
     * @return
     */
    public IPage<QueryAccountResDto> getAccountPage(QueryAccountReqDto reqDto){
        LambdaQueryWrapper<Account> queryWrapper = Wrappers.lambdaQuery(Account.class);
        if(ParamUtil.notEmpty(reqDto.getAccount())){
            queryWrapper.like(Account::getAccount,reqDto.getAccount());
        }
        if(ParamUtil.notEmpty(reqDto.getPhone())){
            queryWrapper.like(Account::getPhone,reqDto.getPhone());
        }
        if(ParamUtil.notEmpty(reqDto.getQqNumber())){
            queryWrapper.like(Account::getQqNumber,reqDto.getQqNumber());
        }
        if(ParamUtil.notEmpty(reqDto.getWeChat())){
            queryWrapper.like(Account::getWeChat,reqDto.getWeChat());
        }
        Page<Account> accountPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(Account::getStatus,9));
        return ToolsUtil.convertType(accountPage,QueryAccountResDto.class);
    }

    /**
     * 添加账号或修改账号校验
     * @param account
     */
    public void checkUser(String account,String id){
        if(ParamUtil.notEmpty(baseMapper.selectList(Wrappers.lambdaQuery(Account.class)
                .ne(Account::getStatus,BlogStatusEnum.DELETE.getCode())
                .eq(Account::getAccount,account)
                .ne(Account::getId,id)))){
            throw new CommonException("该用户名已存在");
        }
    }

    /**
     * id和name集
     * @return
     */
    public List<IdAndNameDto> getAccountData(String name){
        List<Account> accountList = baseMapper.selectList(Wrappers.lambdaQuery(Account.class).eq(Account::getStatus,1).like(Account::getAccount,name));
        List<IdAndNameDto> list = Lists.newArrayList();
        accountList.forEach(a->{
            list.add(new IdAndNameDto().setId(a.getId()).setName(a.getAccount()));
        });
        return list;
    }

    /**
     * 登录接口
     * @param reqDto
     * @return
     */
    public ResponseModelDto<LoginResponseDto> login(LoginReqDto reqDto){
        Account account = baseMapper.selectOne(Wrappers.lambdaQuery(Account.class)
                .eq(Account::getAccount,reqDto.getAccount())
                .eq(Account::getPassword,ToolsUtil.getPasswordToMD5(reqDto.getPassword()))
                .eq(Account::getStatus, BlogStatusEnum.ENABLE.getCode()));
        if(ParamUtil.empty(account)){
            return ResponseModels.loginException();
        }else{
            LoginResponseDto loginResponseDto = ToolsUtil.convertType(account,LoginResponseDto.class);
            loginResponseDto.setToken(loginResponseDto.getId());
            redisUtil.set(key+loginResponseDto.getId(),loginResponseDto.getToken(),10*60*6);
            return ResponseModels.ok(loginResponseDto);
        }
    }

}
