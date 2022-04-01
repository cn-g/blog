package com.example.blog.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.user.UrlMapper;
import com.example.blog.dto.user.request.*;
import com.example.blog.dto.user.response.*;
import com.example.blog.entity.user.Account;
import com.example.blog.entity.user.Url;
import com.example.blog.enums.BlogStatusEnum;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.WebBaseUrl;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.RedisUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Admin
 */
@Service
public class UrlService extends ServiceImpl<UrlMapper, Url> {

    private static final String role = "cache_role_";

    @Resource
    private RoleService roleService;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 添加接口
     * @param reqDto
     * @return
     */
    public Boolean addUrl(AddUrlReqDto reqDto){
        checkUrl(reqDto.getUrl(),"",reqDto.getRoleId());
        Url url = ToolsUtil.convertType(reqDto,Url.class);
        url.setUrl(reqDto.getUrl());
        url.setCreateTime(LocalDateTime.now());
        url.setId(ToolsUtil.getUUID());
        return baseMapper.insert(url) > 0;
    }

    /**
     * 添加账号或修改账号校验
     * @param url
     */
    public void checkUrl(String url,String id,String roleId){
        if(ParamUtil.notEmpty(baseMapper.selectList(Wrappers.lambdaQuery(Url.class)
                .ne(Url::getStatus, BlogStatusEnum.DELETE.getCode())
                .eq(Url::getUrl,url)
                .eq(Url::getRoleId,roleId)
                .ne(Url::getId,id)))){
            throw new CommonException("该接口已存在");
        }
    }

    /**
     * 修改接口
     * @param reqDto
     * @return
     */
    public Boolean updateUrl(UpdateUrlReqDto reqDto){
        checkUrl(reqDto.getUrl(),reqDto.getId(),reqDto.getRoleId());
        Url url = ToolsUtil.convertType(reqDto,Url.class);
        return baseMapper.updateById(url) > 0;
    }

    /**
     * 删除接口
     * @param reqDto
     * @return
     */
    public Boolean deleteUrl(IdRequestDto reqDto){
        Url url = baseMapper.selectById(reqDto.getId());
        url.setStatus(9);
        return baseMapper.updateById(url) > 0;
    }

    /**
     * 分页查询接口
     * @param reqDto
     * @return
     */
    public IPage<QueryUrlResDto> queryUrlPage(QueryUrlReqDto reqDto){
        LambdaQueryWrapper<Url> queryWrapper = Wrappers.lambdaQuery(Url.class);
        if(ParamUtil.notEmpty(reqDto.getUrl())){
            queryWrapper.like(Url::getUrl,reqDto.getUrl());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(Url::getStatus,reqDto.getStatus());
        }
        Page<Url> page = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(Url::getStatus,9).orderByDesc(Url::getCreateTime));
        IPage<QueryUrlResDto> iPage = ToolsUtil.convertType(page, QueryUrlResDto.class);
        int i = 0;
        for (QueryUrlResDto record : iPage.getRecords()) {
            record.setName(roleService.getRole(record.getRoleId()).getName());
            iPage.getRecords().set(i,record);
            i++;
        }
        return iPage;
    }

    /**
     * 保存接口权限到redis
     */
    public void addUrlRoleToRedis(){
        Map<String, List<Url>> map = baseMapper.selectList(Wrappers.lambdaQuery(Url.class).eq(Url::getStatus,BlogStatusEnum.ENABLE.getCode())).stream().collect(Collectors.groupingBy(Url::getRoleId));
        map.forEach((a,b)->{
            String url = String.join(",", b.stream().map(Url::getUrl).collect(Collectors.toList()));
            redisUtil.del(String.format(role+"%s",a));
            redisUtil.set(String.format(role+"%s",a),url);
        });
    }

    /**
     * 批量修改请求路径
     */
    public void updateUrl(){
        List<Url> urlList = baseMapper.selectList(null);
        urlList.forEach(u->{
            u.setUrl("/"+WebBaseUrl.ADMIN_URL+u.getUrl());
            baseMapper.updateById(u);
        });
    }

}
