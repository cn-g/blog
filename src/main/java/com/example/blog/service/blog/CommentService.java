package com.example.blog.service.blog;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dao.blog.CommentMapper;
import com.example.blog.dto.blog.request.AddCommentReqDto;
import com.example.blog.dto.blog.request.AddOperateHistoryDto;
import com.example.blog.dto.blog.response.QueryCommentResDto;
import com.example.blog.entity.blog.Comment;
import com.example.blog.entity.user.Account;
import com.example.blog.entity.user.User;
import com.example.blog.enums.BlogStatusEnum;
import com.example.blog.enums.OperateTypeEnum;
import com.example.blog.service.user.AccountService;
import com.example.blog.service.user.OperateHistoryService;
import com.example.blog.service.user.UserService;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.base.PageIdReqDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.RequestUtil;
import com.gcp.basicproject.util.ToolsUtil;
import com.google.common.collect.Lists;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Admin
 */
@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment> {

    @Resource
    private UserService userService;

    @Resource
    private AccountService accountService;

    @Resource
    private OperateHistoryService operateHistoryService;

    /**
     * 添加评论
     * @param reqDto
     * @return
     */
    public Boolean addComment(AddCommentReqDto reqDto){
        Comment comment = ToolsUtil.convertType(reqDto,Comment.class);
        if(ParamUtil.empty(comment.getReplyId())){
            comment.setReplyId(null);
        }
        if(ParamUtil.empty(comment.getReplyUserId())){
            comment.setReplyUserId(null);
        }
        comment.setUserId(RequestUtil.getUserId());
        comment.setId(ToolsUtil.getUUID());
        comment.setCreateTime(LocalDateTime.now());
        comment.setStatus(BlogStatusEnum.ENABLE.getCode());
        AddOperateHistoryDto dto = new AddOperateHistoryDto();
        dto.setOperateNo(OperateTypeEnum.COMMENT.getCode());
        dto.setBlogId(reqDto.getBlogId());
        operateHistoryService.addOperateHistory(dto);
        return baseMapper.insert(comment) > 0;
    }

    /**
     * 分页获取评论信息
     * @param reqDto
     * @return
     */
    public IPage<QueryCommentResDto> getCommentPage(PageIdReqDto reqDto){
        Page<Comment> page = baseMapper.selectPage(reqDto.iPageInfo(), Wrappers.lambdaQuery(Comment.class)
                .eq(Comment::getBlogId,reqDto.getId())
                .eq(Comment::getStatus,BlogStatusEnum.ENABLE.getCode())
                .isNull(Comment::getReplyId)
                .orderByDesc(Comment::getCreateTime));
        Map<String, Account> accountMap = accountService.getAccountMap();
        if(ParamUtil.empty(page.getRecords())){
            return ToolsUtil.convertType(page,QueryCommentResDto.class);
        }
        Map<String,List<QueryCommentResDto>> commentMap = getChildComment(accountMap);
        IPage<QueryCommentResDto> queryCommentResDtoIPage = ToolsUtil.convertType(page,QueryCommentResDto.class);
        int i = 0;
        for (QueryCommentResDto queryCommentResDto : queryCommentResDtoIPage.getRecords()) {
            queryCommentResDto.setName(accountMap.get(queryCommentResDto.getUserId()).getAccount());
            List<QueryCommentResDto> list = commentMap.get(queryCommentResDto.getId());
            List<QueryCommentResDto> newList = Lists.newArrayList();
            if(ParamUtil.notEmpty(list)){
                newList.addAll(list);
                queryCommentResDto.setChildComment(getChildComment(commentMap,list,newList));
            }
            queryCommentResDto.setInputShow(false);
            queryCommentResDtoIPage.getRecords().set(i,queryCommentResDto);
            i++;
        }
        return queryCommentResDtoIPage;
    }

    /**
     * 递归获取回复评论
     * @param commentMap
     * @param list
     * @param newList
     * @return
     */
    public  List<QueryCommentResDto> getChildComment(Map<String,List<QueryCommentResDto>> commentMap,List<QueryCommentResDto> list,List<QueryCommentResDto> newList){
        for (QueryCommentResDto  q: list) {
            if(ParamUtil.notEmpty(q.getId())){
                if(commentMap.get(q.getId()) != null){
                    newList.addAll(commentMap.get(q.getId()));
                    getChildComment(commentMap,commentMap.get(q.getId()),newList);
                }
            }
        }
        return newList;
    }

    /**
     * 获取回复评论
     * @return
     */
    public Map<String,List<QueryCommentResDto>> getChildComment(Map<String, Account> accountMap){
        List<Comment> commentList = baseMapper.selectList(Wrappers.lambdaQuery(Comment.class)
                .eq(Comment::getStatus,BlogStatusEnum.ENABLE.getCode())
                .isNotNull(Comment::getReplyId)
                .orderByDesc(Comment::getCreateTime));
        List<QueryCommentResDto> queryCommentResDtoList = ToolsUtil.convertType(commentList,QueryCommentResDto.class);
        int i = 0;
        for (QueryCommentResDto queryCommentResDto : queryCommentResDtoList) {
            queryCommentResDto.setReplyUserName(accountMap.get(queryCommentResDto.getReplyUserId()).getAccount());
            queryCommentResDto.setName(accountMap.get(queryCommentResDto.getUserId()).getAccount());
            queryCommentResDto.setInputShow(false);
            queryCommentResDtoList.set(i,queryCommentResDto);
            i++;
        }
        return queryCommentResDtoList.stream().collect(Collectors.groupingBy(QueryCommentResDto::getReplyId));
    }

    /**
     * 删除评论
     * @param reqDto
     * @return
     */
    public Boolean deleteComment(IdRequestDto reqDto){
        Comment comment = baseMapper.selectById(reqDto.getId());
        if(ParamUtil.empty(comment)){
            throw new CommonException("未查询到该评论");
        }
        if(!ParamUtil.equals(RequestUtil.getUserId(),comment.getUserId())){
            throw new CommonException("无法删除他人评论");
        }
        comment.setStatus(BlogStatusEnum.DELETE.getCode());
        return baseMapper.updateById(comment) > 0;
    }

}
