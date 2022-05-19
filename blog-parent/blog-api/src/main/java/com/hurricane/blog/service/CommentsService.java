package com.hurricane.blog.service;

import com.hurricane.blog.vo.params.CommentParam;
import com.hurricane.blog.vo.Result;

public interface CommentsService {

    /**
     * 根据文章id查询所有的评论列表
     * @param id
     * @return
     */
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}

