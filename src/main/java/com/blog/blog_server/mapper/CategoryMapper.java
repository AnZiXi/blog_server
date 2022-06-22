package com.blog.blog_server.mapper;

import com.blog.blog_server.entity.Category;
import org.apache.ibatis.annotations.*;


import java.util.List;


@Mapper
public interface CategoryMapper {

    void createCategory(Category category);

    void deleteCategory(Integer categoryId);

    void updateCategory(Category category);

    List<Category> getAllCategories();

    Category findCategoryByName(String name);

    Category getCategoryById(Integer categoryId);

    List<Category> getCategoryLikeName(String name);

}
