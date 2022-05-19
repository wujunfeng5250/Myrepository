package com.hurricane.blog.utils;

import com.hurricane.blog.dao.pojo.SysUser;
/*
使用ThreadLocal保存登录用户信息
 */
public class UserThreadLocal {
    private UserThreadLocal(){}
    //线程变量隔离
    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();
/*
放入用户信息
 */
    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }
    /*
取出用户信息
    */
    public static SysUser get(){
        return LOCAL.get();
    }
    /*
删除用户信息
    */
    public static void remove(){
        LOCAL.remove();
    }
}
