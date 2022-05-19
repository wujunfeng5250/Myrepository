package com.hurricane.blog.vo.params;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hurricane.blog.vo.CategoryVo;
import com.hurricane.blog.vo.TagVo;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParam {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;
}

