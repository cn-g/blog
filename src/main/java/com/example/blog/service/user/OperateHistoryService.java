package com.example.blog.service.user;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.user.OperateHistoryMapper;
import com.example.blog.dto.blog.request.AddOperateHistoryDto;
import com.example.blog.entity.user.Operate;
import com.example.blog.entity.user.OperateHistory;
import com.example.blog.enums.BlogStatusEnum;
import com.example.blog.enums.OperateTypeEnum;
import com.example.blog.service.blog.EssayService;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.RequestUtil;
import com.gcp.basicproject.util.ToolsUtil;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Service
public class OperateHistoryService extends ServiceImpl<OperateHistoryMapper, OperateHistory> {

    @Resource
    EssayService essayService;

    @Resource
    OperateService operateService;

    /**
     * 添加操作历史
     * @param dto
     * @return
     */
    @GlobalTransactional
    public Boolean addOperateHistory(AddOperateHistoryDto dto){
        String userId = RequestUtil.getUserId();
        if(updateOperateHistory(userId,dto.getBlogId(),dto.getOperateNo())){
            return true;
        }
        Operate operate = operateService.getOperateByOperateNo(ParamUtil.notEmpty(dto.getOperateNo())&&ParamUtil.notEmpty(userId)?dto.getOperateNo():OperateTypeEnum.BROWSE.getCode());
        OperateHistory operateHistory = ToolsUtil.convertType(dto,OperateHistory.class);
        operateHistory.setId(ToolsUtil.getUUID());
        operateHistory.setOperateId(operate.getId());
        operateHistory.setCreateTime(LocalDateTime.now());
        operateHistory.setStatus(BlogStatusEnum.ENABLE.getCode());
        operateHistory.setUserId(ParamUtil.notEmpty(userId)?userId:null);
        //修改博客统计信息
        essayService.updateEssayStatistic(operateHistory.getBlogId(),operateHistory.getOperateNo(),true);
        return baseMapper.insert(operateHistory) > 0;
    }

    /**
     * 浏览记录校验
     * @param userId
     * @param blogId
     */
    private void checkOperateHistoryView(String userId,String blogId){
        List<OperateHistory> operateHistoryList = baseMapper.selectList(Wrappers.lambdaQuery(OperateHistory.class)
                .eq(OperateHistory::getUserId,userId)
                .eq(OperateHistory::getBlogId,blogId)
                .eq(OperateHistory::getOperateNo, OperateTypeEnum.BROWSE.getCode())
                .between(OperateHistory::getCreateTime,LocalDateTime.now().minusMinutes(30),LocalDateTime.now()));
        if(ParamUtil.notEmpty(operateHistoryList)){
            throw new CommonException("浏览记录半个小时内不能重复添加");
        }
    }

    /**
     * 修改操作历史
     * @param userId
     * @param blogId
     * @param operateNo
     * @return
     */
    private Boolean updateOperateHistory(String userId,String blogId,Integer operateNo){
        if(operateNo.equals(OperateTypeEnum.BROWSE.getCode())){
            checkOperateHistoryView(userId,blogId);
            return false;
        }
        OperateHistory operateHistory = baseMapper.selectOne(Wrappers.lambdaQuery(OperateHistory.class)
                .eq(OperateHistory::getUserId,userId)
                .eq(OperateHistory::getBlogId,blogId)
                .eq(OperateHistory::getOperateNo,operateNo)
                .ne(OperateHistory::getStatus,BlogStatusEnum.DELETE.getCode()));
        if(ParamUtil.empty(operateHistory)){
            return false;
        }
        operateHistory.setStatus(BlogStatusEnum.DELETE.getCode());
        operateHistory.setUpdateTime(LocalDateTime.now());
        //修改博客统计信息
        essayService.updateEssayStatistic(operateHistory.getBlogId(),operateHistory.getOperateNo(),false);
        return baseMapper.updateById(operateHistory) > 0;
    }


}
