package com.blog.blog_server.mapper;

import com.blog.blog_server.entity.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface TagMapper {

    void createTag(Tag tag);

    void deleteTag(Integer tagId);

    void updateTag(Tag tag);

    List<Tag> getAllTags();

    Tag findTagByName(String name);

    Tag getTagById(Integer tagId);

    List<Tag> getTagLikeName(String name);
}
