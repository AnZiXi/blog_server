package com.blog.blogserver.service;

import cn.hutool.core.date.DateTime;
import com.blog.blogserver.entity.Category;
import com.blog.blogserver.mapper.CategoryMapper;
import com.blog.blogserver.vo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    public Result createCategory(Category category) {
        if (categoryMapper.findCategoryByName(category.getName()) != null) {
            return new Result(400,"error","栏目已存在");
        }
        category.setCreatetime(new DateTime());
        categoryMapper.createCategory(category);
        return new Result(200,"success","创建成功");
    }


    public Result deleteCategory(Integer categoryId) {
        categoryMapper.deleteCategory(categoryId);
        return new Result(200,"success","删除成功");
    }


    public Result updateCategoryName(Category category) {
        Category c = categoryMapper.getCategoryById(category.getId());
        c.setName(category.getName());
        c.setUpdatetime(new DateTime());
        categoryMapper.updateCategory(c);
        return new Result(200,"success","修改成功");
    }

    public Result getCategoryByName(String name) {
        Category category = categoryMapper.findCategoryByName(name);
        return new Result(200,"success",category);
    }

    public Result getAllCategories() {
        List<Category> categories = categoryMapper.getAllCategories();
        return new Result(200,"success",categories);
    }

    public Result getCategoriesPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Category> categoryList = categoryMapper.getAllCategories();
        PageInfo<Category> PageInfo = new PageInfo<>(categoryList);
        List<Category> categories = PageInfo.getList();
        return new Result(200,"success",categories);
    }

    public Result getCategoriesSearch(Integer currentPage, Integer pageSize, String name) {
        PageHelper.startPage(currentPage,pageSize);
        List<Category> categoryList = categoryMapper.getCategoryLikeName("%" +name+"%");
        PageInfo<Category> PageInfo = new PageInfo<>(categoryList);
        List<Category> categories = PageInfo.getList();
        return new Result(200,"success",categories);
    }
}
