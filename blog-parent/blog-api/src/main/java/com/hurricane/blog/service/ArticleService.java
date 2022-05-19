package com.hurricane.blog.service;

import com.hurricane.blog.vo.Result;
import com.hurricane.blog.vo.params.ArticleParam;
import com.hurricane.blog.vo.params.PageParams;

public interface ArticleService {
    /*
    分页查询 文章列表
     */
    Result listArticle(PageParams pageParams);

    /**
     * 最热文章
     * @param limit
     * @return
     */
    Result hotArticle(int limit);
    /**
     * 最新文章
     * @param limit
     * @return
     */
    Result newArticles(int limit);
    /**
     * 文章归档
     * @param limit
     * @return
     */
    Result listArchives();
    /**
     * 查看文章详情
     * @param articleId
     * @return
     */
    Result findArticleById(Long articleId);
    /**
     * 文章发布服务
     * @param articleParam
     * @return
     */
    Result publish(ArticleParam articleParam);
}
