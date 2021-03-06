package com.blog.blog_server.mapper;

import com.blog.blog_server.entity.Role;
import com.blog.blog_server.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {


    void createUser(User user);

    void addUserRoles(Integer userId,Integer roleId);

    void deleteUser(Integer userId);

    void deleteUserRoles(Integer userId);

    void updateUser(User user);

    User findUserByUsername(String username);

    List<User> getUserLikeUsername(String username);

    List<User> findUserByNickname(String nickname);

    List<User> getUserLikeNickname(String nickname);

    User getUserById(Integer userId);

    List<Role> getRolesByUserId(Integer userId);

    List<User> getAllUsers();
}
