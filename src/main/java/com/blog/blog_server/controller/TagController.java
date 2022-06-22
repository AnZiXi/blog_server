package com.blog.blog_server.controller;

import com.blog.blog_server.entity.Tag;
import com.blog.blog_server.service.TagService;
import com.blog.blog_server.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @ApiOperation(value = "创建标签")
    @PostMapping(path = "/tags")
    public Result createTag(@RequestBody Tag tag){
        return tagService.createTag(tag);
    }

    @ApiOperation(value = "删除标签")
    @DeleteMapping(path = "/tags")
    public Result deleteTag(Integer tagId){
        return tagService.deleteTag(tagId);
    }

    @ApiOperation(value = "修改标签名")
    @PutMapping(path = "/tags")
    public Result updateTagName(@RequestBody Tag tag){
        return tagService.updateTagName(tag);
    }

    @ApiOperation(value = "根据标签名查找标签")
    @GetMapping(path = "/tags/name")
    public Result getTagByName(String name){
        return tagService.getTagByName(name);
    }

    @ApiOperation(value = "查询全部标签")
    @GetMapping(path = "/tags/all")
    public Result getAllTags(){
        return tagService.getAllTags();
    }

    @ApiOperation(value = "分页查询全部标签")
    @GetMapping(path = "/tags/page")
    public Result getTagsPage(Integer currentPage,Integer pageSize){
        return tagService.getTagsPage(currentPage, pageSize);
    }

    @ApiOperation(value = "根据标签名分页搜索标签")
    @GetMapping(path = "/tags/name/search")
    public Result getTagsSearch(Integer currentPage,Integer pageSize,String name){
        return tagService.getTagsSearch(currentPage, pageSize,name);
    }
}
