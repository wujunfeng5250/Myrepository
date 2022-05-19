package com.hurricane.blog.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hurricane.blog.admin.mapper.CommentMapper;
import com.hurricane.blog.admin.model.params.PageParam;
import com.hurricane.blog.admin.pojo.Comment;
import com.hurricane.blog.admin.vo.PageResult;
import com.hurricane.blog.admin.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    public Result listComments(PageParam pageParam) {
        Page<Comment> page = new Page<>(pageParam.getCurrentPage(),pageParam.getPageSize());
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageParam.getQueryString())) {
            queryWrapper.eq(Comment::getContent,pageParam.getQueryString());
        }
        Page<Comment> commentPage = this.commentMapper.selectPage(page, queryWrapper);
        PageResult<Comment> pageResult = new PageResult<>();
        pageResult.setList(commentPage.getRecords());
        pageResult.setTotal(commentPage.getTotal());
        return Result.success(pageResult);
    }



    public Result deletecomment(Long id) {
        this.commentMapper.deleteById(id);
        return Result.success(null);
    }
}

