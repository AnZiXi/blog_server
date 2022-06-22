package com.blog.blogserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "评论")
@Data
public class Comment {

    private Integer id;

    private String content;

    private Integer articleId;

    private Integer userId;

    private Article article;

    private User user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;
}
