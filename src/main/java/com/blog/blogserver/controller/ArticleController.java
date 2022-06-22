package com.blog.blogserver.controller;

import com.blog.blogserver.entity.Article;
import com.blog.blogserver.entity.Comment;
import com.blog.blogserver.service.ArticleService;
import com.blog.blogserver.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ApiOperation(value = "创建博客")
    @PostMapping(path = "/articles")
    public Result createArticle(@RequestBody Article article){
        return articleService.createArticle(article);
    }

    @ApiOperation(value = "发表评论")
    @PostMapping(path = "/articles/comment")
    public Result createArticleComment(@RequestBody Comment comment){
        return articleService.createArticleComment(comment);
    }

    @ApiOperation(value = "删除评论")
    @DeleteMapping(path = "/articles/comment")
    public Result deleteArticleComment(Integer commentId){
        return articleService.deleteArticleComment(commentId);
    }

    @ApiOperation(value = "删除博客")
    @DeleteMapping(path = "/articles")
    public Result deleteArticle(Integer articleId){
        return articleService.deleteArticle(articleId);
    }

    @ApiOperation(value = "修改博客")
    @PutMapping(path = "/articles")
    public Result updateArticle(@RequestBody Article article){
        return articleService.updateArticle(article);
    }

    @ApiOperation(value = "查看博客详情")
    @GetMapping(path = "/articles/detail")
    public Result getArticleDetail(Integer articleId){
        return articleService.getArticleDetail(articleId);
    }

    @ApiOperation(value = "分页查询全部博客")
    @GetMapping(path = "/articles/page")
    public Result getAllArticles(Integer currentPage,Integer pageSize){
        return articleService.getAllArticles(currentPage, pageSize);
    }

    @ApiOperation(value = "根据栏目查询博客")
    @GetMapping(path = "/articles/categories")
    public Result getArticlesByCategoryId(Integer currentPage,Integer pageSize,Integer categoryId){
        return articleService.getArticlesByCategoryId(currentPage, pageSize,categoryId);
    }

    @ApiOperation(value = "分页查询博客的评论")
    @GetMapping(path = "/articles/comments")
    public Result getArticlesComments(Integer currentPage,Integer pageSize,Integer articleId){
        return articleService.getArticlesComments(currentPage, pageSize,articleId);
    }

    @ApiOperation(value = "分页查询用户发表的博客")
    @GetMapping(path = "/articles/users")
    public Result getArticlesByUser(Integer currentPage,Integer pageSize,Integer userId){
        return articleService.getArticlesByUser(currentPage, pageSize,userId);
    }

    @ApiOperation(value = "根据标题分页搜索博客")
    @GetMapping(path = "/articles/title/search")
    public Result getArticlesSearch(Integer currentPage,Integer pageSize,String title){
        return articleService.getArticlesSearch(currentPage, pageSize,title);
    }

}
