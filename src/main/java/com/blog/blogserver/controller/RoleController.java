package com.blog.blogserver.controller;

import com.blog.blogserver.entity.Role;
import com.blog.blogserver.service.RoleService;
import com.blog.blogserver.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation(value = "创建角色")
    @PostMapping(path = "/roles")
    public Result createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping(path = "/roles")
    public Result deleteRole(Integer roleId){
        return roleService.deleteRole(roleId);
    }

    @ApiOperation(value = "修改角色名")
    @PutMapping(path = "/roles")
    public Result updateRoleName(@RequestBody Role role){
        return roleService.updateRoleName(role);
    }

    @ApiOperation(value = "根据角色名查找角色")
    @GetMapping(path = "/roles/name")
    public Result getRoleByName(String name){
        return roleService.getRoleByName(name);
    }

    @ApiOperation(value = "分页查询全部角色")
    @GetMapping(path = "/roles/page")
    public Result getRolesPage(Integer currentPage,Integer pageSize){
        return roleService.getRolesPage(currentPage, pageSize);
    }

    @ApiOperation(value = "查询全部角色")
    @GetMapping(path = "/roles/all")
    public Result getAllRoles(){
        return roleService.getAllRoles();
    }

    @ApiOperation(value = "根据角色名分页搜索角色")
    @GetMapping(path = "/roles/name/search")
    public Result getRolesSearch(Integer currentPage,Integer pageSize,String name){
        return roleService.getRolesSearch(currentPage, pageSize,name);
    }
}
