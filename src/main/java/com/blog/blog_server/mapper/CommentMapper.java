package com.blog.blog_server.mapper;

import com.blog.blog_server.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    void createComment(Comment comment);

    void deleteComment(Integer commentId);

    void updateComment(Comment comment);

    List<Comment> getAllComments();

    Comment getCommentById(Integer commentId);

    List<Comment> getCommentByArticleId(Integer articleId);

    List<Comment> getCommentsLikeContent(String content);

    List<Comment> getCommentsByUserId(Integer userId);
}
