package com.blog.blog_server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel(value = "博客")
@Data
public class Article {

    private Integer id;

    private String title;

    private String summary;

    private String content;

    private Integer userId;

    private Integer categoryId;

    private Integer readsize = 0;

    private Integer commentsize = 0;

    private User user;

    private Category category;

    private List<Tag> tags;

    private List<Comment> comments;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;


}
