package com.hurricane.blog.admin.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SysUser {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String account;

    private String password;

    private String nickname;

    private Long createDate;





}
