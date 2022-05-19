package com.hurricane.blog.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hurricane.blog.admin.mapper.TagMapper;
import com.hurricane.blog.admin.model.params.PageParam;
import com.hurricane.blog.admin.pojo.Tag;
import com.hurricane.blog.admin.vo.PageResult;
import com.hurricane.blog.admin.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagMapper tagMapper;
    public Result listTag(PageParam pageParam) {
        Page<Tag> page = new Page<>(pageParam.getCurrentPage(),pageParam.getPageSize());
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageParam.getQueryString())) {
            queryWrapper.eq(Tag::getTagName,pageParam.getQueryString());
        }
        Page<Tag> tagPage = this.tagMapper.selectPage(page, queryWrapper);
        PageResult<Tag> pageResult = new PageResult<>();
        pageResult.setList(tagPage.getRecords());
        pageResult.setTotal(tagPage.getTotal());
        return Result.success(pageResult);
    }
    public Result addtag(Tag tag) {
        this.tagMapper.insert(tag);
        return Result.success(null);
    }

    public Result updatetag(Tag tag) {
        this.tagMapper.updateById(tag);
        return Result.success(null);
    }

    public Result deletetag(Long id) {
        this.tagMapper.deleteById(id);
        return Result.success(null);
    }
}
