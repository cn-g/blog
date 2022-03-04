package com.example.blog.service.home;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.home.SearchMapper;
import com.example.blog.dto.home.request.*;
import com.example.blog.dto.home.response.*;
import com.example.blog.entity.home.Channel;
import com.example.blog.entity.home.Search;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Admin
 */
@Service
public class SearchService extends ServiceImpl<SearchMapper, Search> {

    /**
     * 添加关键字
     * @param reqDto
     * @return
     */
    public Boolean addSearch(AddSearchReqDto reqDto){
        Search search = ToolsUtil.convertType(reqDto,Search.class);
        search.setId(ToolsUtil.getUUID());
        search.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(search) > 0;
    }

    /**
     * 修改关键字
     * @param reqDto
     * @return
     */
    public Boolean updateSearch(UpdateSearchReqDto reqDto){
        Search search = ToolsUtil.convertType(reqDto,Search.class);
        search.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(search) > 0;
    }

    /**
     * 删除关键字
     * @param reqDto
     * @return
     */
    public Boolean deleteSearch(IdRequestDto reqDto){
        Search search = baseMapper.selectById(reqDto.getId());
        search.setStatus(9);
        search.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(search) > 0;
    }

    /**
     * 分页查询关键字
     * @param reqDto
     * @return
     */
    public IPage<QuerySearchResDto> getSearchPage(QuerySearchReqDto reqDto){
        LambdaQueryWrapper<Search> queryWrapper = new LambdaQueryWrapper<>();
        if(ParamUtil.notEmpty(reqDto.getKeyWord())){
            queryWrapper.like(Search::getKeyWord,reqDto.getKeyWord());
        }
        if(ParamUtil.notEmpty(reqDto.getStatus())){
            queryWrapper.eq(Search::getStatus,reqDto.getStatus());
        }
        Page<Search> searchPage = baseMapper.selectPage(reqDto.iPageInfo(),queryWrapper.ne(Search::getStatus,9));
        return ToolsUtil.convertType(searchPage,QuerySearchResDto.class);
    }

    /**
     * 查询关键字
     * @param reqDto
     * @return
     */
    public QuerySearchResDto getSearch(IdRequestDto reqDto){
        Search search = baseMapper.selectById(reqDto.getId());
        return ToolsUtil.convertType(search,QuerySearchResDto.class);
    }

}
