package com.hurricane.blog.service;

import com.hurricane.blog.vo.Result;
import com.hurricane.blog.vo.CategoryVo;


public interface CategoryService {

    CategoryVo findCategoryById(Long id);

    Result findAll();

    Result findAllDetail();

    Result categoriesDetailById(Long id);
}

