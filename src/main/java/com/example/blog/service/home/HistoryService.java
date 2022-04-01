package com.example.blog.service.home;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.home.HistoryMapper;
import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.entity.home.History;
import com.example.blog.entity.home.Search;
import com.example.blog.enums.BlogStatusEnum;
import com.example.blog.service.user.AccountService;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.WebBaseUrl;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Admin
 */
@Service
public class HistoryService extends ServiceImpl<HistoryMapper, History> {

    @Resource
    private AccountService accountService;

    /**
     * 添加历史关键字
     * @param reqDto
     * @return
     */
    public Boolean addHistory(AddHistoryReqDto reqDto){
        History history = ToolsUtil.convertType(reqDto,History.class);
        history.setId(ToolsUtil.getUUID());
        history.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(history) > 0;
    }

    /**
     * 修改历史关键字
     * @param reqDto
     * @return
     */
    public Boolean updateHistory(UpdateHistoryReqDto reqDto){
        History history = ToolsUtil.convertType(reqDto,History.class);
        return baseMapper.updateById(history) > 0;
    }

    /**
     * 删除历史关键字
     * @param reqDto
     * @return
     */
    public Boolean deleteHistory(IdRequestDto reqDto){
        History history = baseMapper.selectById(reqDto.getId());
        history.setStatus(9);
        return baseMapper.updateById(history) > 0;
    }

    /**
     * 分页历史关键字
     * @param reqDto
     * @return
     */
    public IPage<QueryHistoryResDto> getHistoryPage(QuerySearchReqDto reqDto){
        LambdaQueryWrapper<History> queryWrapper = new LambdaQueryWrapper<>();
        if(ParamUtil.notEmpty(reqDto.getKeyWord())){
            queryWrapper.like(History::getKeyWord,reqDto.getKeyWord());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(History::getStatus,reqDto.getStatus());
        }
        Page<History> historyPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(History::getStatus,9));
        IPage<QueryHistoryResDto> queryHistoryResDtoIPage = ToolsUtil.convertType(historyPage,QueryHistoryResDto.class);
        int i = 0;
        for (QueryHistoryResDto record : queryHistoryResDtoIPage.getRecords()) {
            record.setBlogUserName(accountService.getAccount(new IdRequestDto().setId(record.getBlogUserId())).getAccount());
            queryHistoryResDtoIPage.getRecords().set(i,record);
            i++;
        }
        return queryHistoryResDtoIPage.setRecords(queryHistoryResDtoIPage.getRecords());
    }

    /**
     * 查询历史关键字
     * @param reqDto
     * @return
     */
    public QueryHistoryResDto getHistory(IdRequestDto reqDto){
        History history = baseMapper.selectById(reqDto.getId());
        return ToolsUtil.convertType(history,QueryHistoryResDto.class);
    }

    /**
     * 首页历史搜索关键字接口
     * @return
     */
    public List<QueryHistoryResDto> getHistoryList(){
        List<History> historyList = baseMapper.selectList(Wrappers.lambdaQuery(History.class).eq(History::getStatus, BlogStatusEnum.ENABLE.getCode()).orderByDesc(History::getCreateTime).last("limit 10"));
        return ToolsUtil.convertType(historyList,QueryHistoryResDto.class);
    }

}
