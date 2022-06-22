package com.blog.blog_server.mapper;

import com.blog.blog_server.entity.Role;
import org.apache.ibatis.annotations.*;


import java.util.List;


@Mapper
public interface RoleMapper {

    void createRole(Role role);

    void deleteRole(Integer roleId);

    void updateRole(Role role);

    Role findRoleByName(String name);

    Role getRoleById(Integer roleId);

    List<Role> getAllRoles();

    List<Role> getRoleByUserId(Integer userId);

    List<Role> getRoleLikeName(String name);

}
