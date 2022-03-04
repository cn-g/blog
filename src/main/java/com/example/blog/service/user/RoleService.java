package com.example.blog.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.user.RoleMapper;
import com.example.blog.dto.IdAndNameDto;
import com.example.blog.dto.user.request.AddRoleReqDto;
import com.example.blog.dto.user.request.QueryRoleReqDto;
import com.example.blog.dto.user.request.UpdateRoleReqDto;
import com.example.blog.dto.user.response.QueryRoleResDto;
import com.example.blog.entity.user.Account;
import com.example.blog.entity.user.Role;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    /**
     * 添加角色
     * @param reqDto
     * @return
     */
    public Boolean addRole(AddRoleReqDto reqDto){
        Role role = ToolsUtil.convertType(reqDto,Role.class);
        role.setCreateTime(LocalDateTime.now());
        role.setId(ToolsUtil.getUUID());
        return baseMapper.insert(role) > 0;
    }

    /**
     * 修改角色
     * @param reqDto
     * @return
     */
    public Boolean updateRole(UpdateRoleReqDto reqDto){
        Role role = ToolsUtil.convertType(reqDto,Role.class);
        role.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(role) > 0;
    }

    /**
     * 删除角色
     * @param reqDto
     * @return
     */
    public Boolean deleteRole(IdRequestDto reqDto){
        Role role = baseMapper.selectById(reqDto.getId());
        role.setUpdateTime(LocalDateTime.now());
        role.setStatus(9);
        return baseMapper.updateById(role) > 0;
    }

    /**
     * 分页查询角色
     * @param reqDto
     * @return
     */
    public IPage<QueryRoleResDto> queryRolePage(QueryRoleReqDto reqDto){
        LambdaQueryWrapper<Role> queryWrapper = Wrappers.lambdaQuery(Role.class);
        if(ParamUtil.notEmpty(reqDto.getName())){
            queryWrapper.like(Role::getRoleDec,reqDto.getName());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(Role::getStatus,reqDto.getStatus());
        }
        Page page = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(Role::getStatus,9).orderByDesc(Role::getCreateTime));
        return ToolsUtil.convertType(page, QueryRoleResDto.class);
    }

    /**
     * id和name集
     * @return
     */
    public List<IdAndNameDto> getRoleData(){
        List<Role> roleList = baseMapper.selectList(Wrappers.lambdaQuery(Role.class).eq(Role::getStatus,1));
        return ToolsUtil.convertType(roleList,IdAndNameDto.class);
    }

    public Role getRole(String id){
        return baseMapper.selectById(id);
    }



}
