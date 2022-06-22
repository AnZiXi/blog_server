package com.blog.blog_server.service;


import cn.hutool.core.date.DateTime;
import com.blog.blog_server.entity.Role;
import com.blog.blog_server.entity.User;
import com.blog.blog_server.mapper.RoleMapper;
import com.blog.blog_server.mapper.UserMapper;
import com.blog.blog_server.vo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class UserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findUserByUsername(username);
        if (user == null) {
            throw  new UsernameNotFoundException("用户不存在!");
        }
        List<Role> roles = roleMapper.getRoleByUserId(user.getId());
        user.setRoles(roles);
        return user;
    }


    public Result createUser(User user) {
        if (userMapper.findUserByUsername(user.getUsername()) != null) {
            return new Result(400,"error","用户已存在");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword().trim()));
        user.setNickname("博客" + UUID.randomUUID().toString().replaceAll("-","").substring(0,5));
        user.setCreatetime(new DateTime());
        userMapper.createUser(user);
        Role role = roleMapper.findRoleByName("ROLE_USER");
        userMapper.addUserRoles(user.getId(),role.getId());
        return new Result(200,"success","注册成功");
    }


    public Result deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
        return new Result(200,"success","删除成功");
    }


    public Result updateUser(User user) {
        User u = userMapper.getUserById(user.getId());
        u.setNickname(user.getNickname());
        u.setUpdatetime(new DateTime());
        userMapper.updateUser(u);
        userMapper.deleteUserRoles(user.getId());
        for(Role role : user.getRoles()){
            userMapper.addUserRoles(user.getId(),role.getId());
        }
        return new Result(200,"success","修改成功");
    }


    public Result getUserByNickname(Integer currentPage,Integer pageSize,String nickname) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = userMapper.findUserByNickname(nickname);
        PageInfo<User> PageInfo = new PageInfo<>(userList);
        List<User> users = PageInfo.getList();
        return new Result(200,"success",users);
    }

    public Result getUserLikeNickname(Integer currentPage,Integer pageSize,String nickname) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = userMapper.getUserLikeNickname("%" +nickname+"%");
        PageInfo<User> PageInfo = new PageInfo<>(userList);
        List<User> users = PageInfo.getList();
        return new Result(200,"success",users);
    }

    public Result getUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return new Result(200,"success",user);
    }

    public Result getUserLikeUsername(Integer currentPage,Integer pageSize,String username) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = userMapper.getUserLikeUsername("%" +username+"%");
        PageInfo<User> PageInfo = new PageInfo<>(userList);
        List<User> users = PageInfo.getList();
        return new Result(200,"success",users);
    }


    public Result getAllUsers(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = userMapper.getAllUsers();
        PageInfo<User> PageInfo = new PageInfo<>(userList);
        List<User> users = PageInfo.getList();
        return new Result(200,"success",users);
    }

}
