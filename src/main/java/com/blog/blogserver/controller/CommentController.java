package com.blog.blogserver.controller;

import com.blog.blogserver.entity.Comment;
import com.blog.blogserver.service.CommentService;
import com.blog.blogserver.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "修改评论")
    @PutMapping(path = "/comments")
    public Result updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    @ApiOperation(value = "分页查询全部评论")
    @GetMapping(path = "/comments/page")
    public Result getAllComments(Integer currentPage,Integer pageSize){
        return commentService.getAllComments(currentPage, pageSize);
    }

    @ApiOperation(value = "分页查询用户发表的评论")
    @GetMapping(path = "/comments/users")
    public Result getCommentsByUser(Integer currentPage,Integer pageSize,Integer userId){
        return commentService.getCommentsByUser(currentPage, pageSize,userId);
    }

    @ApiOperation(value = "根据内容分页搜索评论")
    @GetMapping(path = "/comments/content/search")
    public Result getCommentsSearch(Integer currentPage,Integer pageSize,String content){
        return commentService.getCommentsSearch(currentPage, pageSize,content);
    }
}
