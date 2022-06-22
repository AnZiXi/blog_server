package com.blog.blog_server.service;

import cn.hutool.core.date.DateTime;
import com.blog.blog_server.entity.*;
import com.blog.blog_server.mapper.ArticleMapper;
import com.blog.blog_server.mapper.CommentMapper;
import com.blog.blog_server.vo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class ArticleService {
    
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private CommentMapper commentMapper;



    public Result createArticle(Article article) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        article.setCommentsize(0);
        article.setReadsize(0);
        article.setUserId(user.getId());
        article.setCategoryId(article.getCategoryId());
        article.setCreatetime(new DateTime());
        articleMapper.createArticle(article);
        for(Tag tag:article.getTags()){
            articleMapper.addArticleTags(article.getId(),tag.getId());
        }
        return new Result(200,"success","创建成功");
    }

    public Result createArticleComment(Comment comment) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            comment.setUserId(user.getId());
            comment.setArticleId(comment.getArticleId());
            comment.setContent(comment.getContent());
            comment.setCreatetime(new DateTime());
            commentMapper.createComment(comment);
            Article article = articleMapper.getArticleById(comment.getArticleId());
            articleMapper.addArticleComment(article.getId(),comment.getId());
            article.setCommentsize(article.getCommentsize() + 1);
            article.setReadsize(article.getCommentsize() +1);
            article.setUpdatetime(new DateTime());
            articleMapper.updateArticleComment(article);
        return new Result(200,"success","评论成功");
    }

    public Result deleteArticleComment(Integer commentId) {
        Comment comment = commentMapper.getCommentById(commentId);
        commentMapper.deleteComment(commentId);
        articleMapper.deleteArticleComment(comment.getArticleId(),commentId);
        Article article = articleMapper.getArticleById(comment.getArticleId());
        article.setCommentsize(article.getCommentsize() - 1);
        article.setReadsize(article.getReadsize() - 1);
        article.setUpdatetime(new DateTime());
        articleMapper.updateArticleComment(article);
        return new Result(200,"success","评论删除成功");
    }

    public Result deleteArticle(Integer articleId) {
        articleMapper.deleteArticle(articleId);
        return new Result(200,"success","删除成功");
    }


    public Result updateArticle(Article article) {
        article.setUpdatetime(new DateTime());
        articleMapper.updateArticle(article);
        articleMapper.deleteArticleTags(article.getId());
        for(Tag tag:article.getTags()){
            articleMapper.addArticleTags(article.getId(),tag.getId());
        }
        return new Result(200,"success","修改成功");
    }

    public Result getAllArticles(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Article> articleList = articleMapper.getAllArticles();
        PageInfo<Article> PageInfo = new PageInfo<>(articleList);
        List<Article> articles = PageInfo.getList();
        return new Result(200,"success",articles);
    }

    public Result getArticlesByCategoryId(Integer currentPage,Integer pageSize,Integer categoryId) {
        PageHelper.startPage(currentPage,pageSize);
        List<Article> articleList = articleMapper.getArticlesByCategoryId(categoryId);
        PageInfo<Article> PageInfo = new PageInfo<>(articleList);
        List<Article> articles = PageInfo.getList();
        return new Result(200,"success",articles);
    }


    public Result getArticleDetail(Integer articleId) {
        Article article = articleMapper.getArticleById(articleId);
        return new Result(200,"success",article);
    }

    public Result getArticlesComments(Integer currentPage, Integer pageSize, Integer articleId) {
        PageHelper.startPage(currentPage,pageSize);
        List<Comment> commentList = commentMapper.getCommentByArticleId(articleId);
        PageInfo<Comment> PageInfo = new PageInfo<>(commentList);
        List<Comment> comments = PageInfo.getList();
        return new Result(200,"success",comments);
    }

    public Result getArticlesByUser(Integer currentPage, Integer pageSize, Integer userId) {
        PageHelper.startPage(currentPage,pageSize);
        List<Article> articleList = articleMapper.getArticlesByUserId(userId);
        PageInfo<Article> PageInfo = new PageInfo<>(articleList);
        List<Article> articles = PageInfo.getList();
        return new Result(200,"success",articles);
    }

    public Result getArticlesSearch(Integer currentPage, Integer pageSize, String title) {
        PageHelper.startPage(currentPage,pageSize);
        List<Article> articleList = articleMapper.getArticlesLikeTitle("%" +title+"%");
        PageInfo<Article> PageInfo = new PageInfo<>(articleList);
        List<Article> articles = PageInfo.getList();
        return new Result(200,"success",articles);
    }
}
