package com.hurricane.blog.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysUser {
@TableId(type = IdType.ASSIGN_ID)//默认ID
//以后用户多了就要分表操作，id就需要分布式ID（雪花算法）


    private Long id;

    private String account;

    private Integer admin;

    private String avatar;

    private Long createDate;




    private Long lastLogin;



    private String nickname;

    private String password;


}

