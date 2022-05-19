package com.hurricane.blog.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hurricane.blog.admin.mapper.SysUserMapper;
import com.hurricane.blog.admin.model.params.PageParam;
import com.hurricane.blog.admin.pojo.SysUser;
import com.hurricane.blog.admin.vo.PageResult;
import com.hurricane.blog.admin.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysuserMapper;
    public Result listSysusers(PageParam pageParam) {
        Page<SysUser> page = new Page<>(pageParam.getCurrentPage(),pageParam.getPageSize());
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageParam.getQueryString())) {
            queryWrapper.eq(SysUser::getAccount,pageParam.getQueryString());
        }
        Page<SysUser> sysuserPage = this.sysuserMapper.selectPage(page, queryWrapper);
        PageResult<SysUser> pageResult = new PageResult<>();
        pageResult.setList(sysuserPage.getRecords());
        pageResult.setTotal(sysuserPage.getTotal());
        return Result.success(pageResult);
    }


    public Result updateuser(SysUser sysuser) {
        this.sysuserMapper.updateById(sysuser);
        return Result.success(null);
    }

    public Result deleteuser(Long id) {
        this.sysuserMapper.deleteById(id);
        return Result.success(null);
    }
}
