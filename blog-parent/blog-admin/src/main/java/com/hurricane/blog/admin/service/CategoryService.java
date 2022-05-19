package com.hurricane.blog.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hurricane.blog.admin.mapper.CategoryMapper;
import com.hurricane.blog.admin.model.params.PageParam;
import com.hurricane.blog.admin.pojo.Category;
import com.hurricane.blog.admin.vo.PageResult;
import com.hurricane.blog.admin.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    public Result listCategory(PageParam pageParam) {
        Page<Category> page = new Page<>(pageParam.getCurrentPage(),pageParam.getPageSize());
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageParam.getQueryString())) {
            queryWrapper.eq(Category::getCategoryName,pageParam.getQueryString());
        }
        Page<Category> categoryPage = this.categoryMapper.selectPage(page, queryWrapper);
        PageResult<Category> pageResult = new PageResult<>();
        pageResult.setList(categoryPage.getRecords());
        pageResult.setTotal(categoryPage.getTotal());
        return Result.success(pageResult);
    }
    public Result addcategory(Category category) {
        this.categoryMapper.insert(category);
        return Result.success(null);
    }

    public Result updatecategory(Category category) {
        this.categoryMapper.updateById(category);
        return Result.success(null);
    }

    public Result deletecategory(Long id) {
        this.categoryMapper.deleteById(id);
        return Result.success(null);
    }
}
