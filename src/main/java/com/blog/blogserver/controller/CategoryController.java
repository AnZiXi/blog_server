package com.blog.blogserver.controller;


import com.blog.blogserver.entity.Category;
import com.blog.blogserver.service.CategoryService;
import com.blog.blogserver.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "栏目接口")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "创建栏目")
    @PostMapping(path = "/categories")
    public Result createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @ApiOperation(value = "删除栏目")
    @DeleteMapping(path = "/categories")
    public Result deleteCategory(Integer categoryId){
        return categoryService.deleteCategory(categoryId);
    }

    @ApiOperation(value = "修改栏目名")
    @PutMapping(path = "/categories")
    public Result updateCategoryName(@RequestBody Category category){
        return categoryService.updateCategoryName(category);
    }

    @ApiOperation(value = "根据栏目名查找栏目")
    @GetMapping(path = "/categories/name")
    public Result getCategoryByName(String name){
        return categoryService.getCategoryByName(name);
    }

    @ApiOperation(value = "查询全部栏目")
    @GetMapping(path = "/categories/all")
    public Result getAllCategories(){
        return categoryService.getAllCategories();
    }

    @ApiOperation(value = "分页查询全部栏目")
    @GetMapping(path = "/categories/page")
    public Result getCategoriesPage(Integer currentPage,Integer pageSize){
        return categoryService.getCategoriesPage(currentPage, pageSize);
    }

    @ApiOperation(value = "根据栏目名分页搜索栏目")
    @GetMapping(path = "/categories/name/search")
    public Result getCategoriesSearch(Integer currentPage,Integer pageSize,String name){
        return categoryService.getCategoriesSearch(currentPage, pageSize,name);
    }

}
