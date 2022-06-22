package com.blog.blogserver.service;

import cn.hutool.core.date.DateTime;
import com.blog.blogserver.entity.Comment;
import com.blog.blogserver.mapper.CommentMapper;
import com.blog.blogserver.vo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    public Result updateComment(Comment comment) {
        Comment c = commentMapper.getCommentById(comment.getId());
        c.setContent(comment.getContent());
        c.setUpdatetime(new DateTime());
        commentMapper.updateComment(c);
        return new Result(200,"success","修改成功");
    }

    public Result getAllComments(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Comment> commentList = commentMapper.getAllComments();
        PageInfo<Comment> PageInfo = new PageInfo<>(commentList);
        List<Comment> comments = PageInfo.getList();
        return new Result(200,"success",comments);
    }

    public Result getCommentsSearch(Integer currentPage, Integer pageSize, String content) {
        PageHelper.startPage(currentPage,pageSize);
        List<Comment> commentList = commentMapper.getCommentsLikeContent("%" +content+"%");
        PageInfo<Comment> PageInfo = new PageInfo<>(commentList);
        List<Comment> comments = PageInfo.getList();
        return new Result(200,"success",comments);
    }

    public Result getCommentsByUser(Integer currentPage, Integer pageSize, Integer userId) {
        PageHelper.startPage(currentPage,pageSize);
        List<Comment> commentList = commentMapper.getCommentsByUserId(userId);
        PageInfo<Comment> PageInfo = new PageInfo<>(commentList);
        List<Comment> comments = PageInfo.getList();
        return new Result(200,"success",comments);
    }
}
