package com.hurricane.blog.admin.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Tag {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String avatar;

    private String tagName;
}
