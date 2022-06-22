package com.blog.blog_server.service;

import cn.hutool.core.date.DateTime;
import com.blog.blog_server.entity.Role;
import com.blog.blog_server.mapper.RoleMapper;
import com.blog.blog_server.vo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleService {

    @Resource
    private RoleMapper roleMapper;


    public Result createRole(Role role) {
        if (roleMapper.findRoleByName(role.getName()) != null) {
            return new Result(400,"error","角色已存在");
        }
        role.setCreatetime(new DateTime());
        roleMapper.createRole(role);
        return new Result(200,"success","创建成功");
    }


    public Result deleteRole(Integer roleId) {
        roleMapper.deleteRole(roleId);
        return new Result(200,"success","删除成功");
    }

    public Result updateRoleName(Role role) {
        Role r = roleMapper.getRoleById(role.getId());
        r.setName(role.getName());
        r.setUpdatetime(new DateTime());
        roleMapper.updateRole(r);
        return new Result(200,"success","修改成功");
    }



    public Result getRoleByName(String name) {
        Role role = roleMapper.findRoleByName(name);
        return new Result(200,"success",role);
    }


    public Result getAllRoles() {
        List<Role> roles = roleMapper.getAllRoles();
        return new Result(200,"success",roles);
    }

    public Result getRolesPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Role> roleList = roleMapper.getAllRoles();
        PageInfo<Role> PageInfo = new PageInfo<>(roleList);
        List<Role> roles = PageInfo.getList();
        return new Result(200,"success",roles);
    }

    public Result getRolesSearch(Integer currentPage, Integer pageSize, String name) {
        PageHelper.startPage(currentPage,pageSize);
        List<Role> roleList = roleMapper.getRoleLikeName("%" +name+"%");
        PageInfo<Role> PageInfo = new PageInfo<>(roleList);
        List<Role> roles = PageInfo.getList();
        return new Result(200,"success",roles);
    }
}
