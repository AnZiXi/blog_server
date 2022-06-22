package com.blog.blog_server.service;

import cn.hutool.core.date.DateTime;
import com.blog.blog_server.entity.Tag;
import com.blog.blog_server.mapper.TagMapper;
import com.blog.blog_server.vo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TagService {

    @Resource
    private TagMapper tagMapper;


    public Result createTag(Tag tag) {
        if (tagMapper.findTagByName(tag.getName()) != null) {
            return new Result(400,"error","角色已存在");
        }
        tag.setCreatetime(new DateTime());
        tagMapper.createTag(tag);
        return new Result(200,"success","创建成功");
    }


    public Result deleteTag(Integer tagId) {
        tagMapper.deleteTag(tagId);
        return new Result(200,"success","删除成功");
    }



    public Result updateTagName(Tag tag) {
        Tag r = tagMapper.getTagById(tag.getId());
        r.setName(tag.getName());
        r.setUpdatetime(new DateTime());
        tagMapper.updateTag(r);
        return new Result(200,"success","修改成功");
    }



    public Result getTagByName(String name) {
        Tag tag = tagMapper.findTagByName(name);
        return new Result(200,"success",tag);
    }


    public Result getAllTags() {
        List<Tag> tags = tagMapper.getAllTags();
        return new Result(200,"success",tags);
    }

    public Result getTagsPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Tag> tagList = tagMapper.getAllTags();
        PageInfo<Tag> PageInfo = new PageInfo<>(tagList);
        List<Tag> tags = PageInfo.getList();
        return new Result(200,"success",tags);
    }

    public Result getTagsSearch(Integer currentPage, Integer pageSize, String name) {
        PageHelper.startPage(currentPage,pageSize);
        List<Tag> tagList = tagMapper.getTagLikeName("%" +name+"%");
        PageInfo<Tag> PageInfo = new PageInfo<>(tagList);
        List<Tag> tags = PageInfo.getList();
        return new Result(200,"success",tags);
    }
}
