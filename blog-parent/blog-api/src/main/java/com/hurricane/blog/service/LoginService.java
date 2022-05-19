package com.hurricane.blog.service;

import com.hurricane.blog.dao.pojo.SysUser;
import com.hurricane.blog.vo.Result;
import com.hurricane.blog.vo.params.LoginParam;
import org.springframework.transaction.annotation.Transactional;

@Transactional//加上事务，防止注册报错了但是数据库还是加入了数据
public interface LoginService {
    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     * 注册功能
     * @param loginParam
     * @return
     */
    Result register(LoginParam loginParam);
}
