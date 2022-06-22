package com.blog.blogserver.mapper;

import com.blog.blogserver.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ArticleMapper {

    void createArticle(Article article);

    void addArticleTags(Integer articleId, Integer tagId);

    void addArticleComment(Integer articleId, Integer commentId);

    void deleteArticle(Integer articleId);

    void deleteArticleComment(Integer articleId,Integer commentId);

    void deleteArticleTags(Integer articleId);

    void updateArticle(Article article);

    void updateArticleComment(Article article);

    Article getArticleById(Integer articleId);

    List<Article> getArticlesByCategoryId(Integer categoryId);

    List<Article> getAllArticles();

    List<Article> getArticlesByUserId(Integer userId);

    List<Article> getArticlesLikeTitle(String title);
}
