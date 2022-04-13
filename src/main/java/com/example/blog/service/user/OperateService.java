package com.example.blog.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.user.OperateMapper;
import com.example.blog.dto.user.request.*;
import com.example.blog.dto.user.response.QueryOperateResDto;
import com.example.blog.entity.user.Operate;
import com.example.blog.enums.BlogStatusEnum;
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
public class OperateService extends ServiceImpl<OperateMapper, Operate> {

    /**
     * 添加操作
     * @param reqDto
     * @return
     */
    public Boolean addOperate(AddOperateReqDto reqDto){
        checkOperate(reqDto.getOperateNo(),null);
        Operate operate = ToolsUtil.convertType(reqDto,Operate.class);
        operate.setId(ToolsUtil.getUUID());
        operate.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(operate) > 0;
    }

    private void checkOperate(Integer operateNo,String id){
        Operate operate = baseMapper.selectOne(Wrappers.lambdaQuery(Operate.class)
                .ne(ParamUtil.notEmpty(id),Operate::getId,id)
                .ne(Operate::getStatus, BlogStatusEnum.DELETE.getCode())
                .eq(Operate::getOperateNo,operateNo));
        if(ParamUtil.notEmpty(operate)){
            throw new CommonException("该编号已存在，请更换");
        }
    }
    /**
     * 分页查询操作
     * @param reqDto
     * @return
     */
    public IPage<QueryOperateResDto> queryOperatePage(QueryOperateReqDto reqDto){
        LambdaQueryWrapper<Operate> queryWrapper = Wrappers.lambdaQuery(Operate.class);
        if(ParamUtil.notEmpty(reqDto.getName())){
            queryWrapper.eq(Operate::getName,reqDto.getName());
        }
        if(ParamUtil.notEmpty(reqDto.getOperateDesc())){
            queryWrapper.like(Operate::getOperateDesc,reqDto.getOperateDesc());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(Operate::getStatus,reqDto.getStatus());
        }
        Page<Operate> operatePage = baseMapper.selectPage(reqDto.iPageInfo(), queryWrapper.ne(Operate::getStatus,BlogStatusEnum.DELETE.getCode()).orderByDesc(Operate::getCreateTime));
        IPage<QueryOperateResDto> queryOperateResDtoIPage = ToolsUtil.convertType(operatePage,QueryOperateResDto.class);
        return queryOperateResDtoIPage;
    }

    /**
     * 查询操作
     * @param idRequestDto
     * @return
     */
    public QueryOperateResDto getOperate(IdRequestDto idRequestDto){
        Operate operate = baseMapper.selectById(idRequestDto.getId());
        if(ParamUtil.empty(operate)){
            throw new CommonException("未查询到该用户");
        }
        return ToolsUtil.convertType(operate,QueryOperateResDto.class);
    }

    /**
     * 修改操作
     * @param reqDto
     * @return
     */
    public Boolean updateOperate(UpdateOperateReqDto reqDto){
        checkOperate(reqDto.getOperateNo(),reqDto.getId());
        Operate operate = ToolsUtil.convertType(reqDto,Operate.class);
        operate.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(operate) > 0;
    }

    /**
     * 删除操作
     * @param idRequestDto
     * @return
     */
    public Boolean deleteOperate(IdRequestDto idRequestDto){
        Operate operate = baseMapper.selectById(idRequestDto.getId());
        if(ParamUtil.empty(operate)){
            return true;
        }
        operate.setStatus(BlogStatusEnum.DELETE.getCode());
        operate.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(operate) > 0;
    }

    /**
     * 通过操作编号查询操作
     * @param operateNo
     * @return
     */
    public Operate getOperateByOperateNo(Integer operateNo){
        Operate operate = baseMapper.selectOne(Wrappers.lambdaQuery(Operate.class).ne(Operate::getStatus,BlogStatusEnum.DELETE.getCode()).eq(Operate::getOperateNo,operateNo));
        if(ParamUtil.empty(operate)){
            throw new CommonException("未查询到该编号");
        }
        return operate;
    }
}
