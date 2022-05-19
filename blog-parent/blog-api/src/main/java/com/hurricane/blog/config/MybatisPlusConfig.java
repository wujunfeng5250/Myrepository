package com.hurricane.blog.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.hurricane.blog.dao.mapper")//包的路径
public class MybatisPlusConfig {
    //分页插件
    @Bean
    public MybatisPlusInterceptor MybatisPlusInterceptor(){
      MybatisPlusInterceptor interceptor  =new MybatisPlusInterceptor();
      interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
      return interceptor;
    }
}
