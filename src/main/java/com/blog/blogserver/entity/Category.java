package com.blog.blogserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "栏目")
@Data
public class Category {

    private Integer id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;


}