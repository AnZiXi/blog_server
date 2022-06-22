package com.blog.blog_server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;

@ApiModel(value = "角色")
@Data
public class Role implements GrantedAuthority {

    private Integer id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    @Override
    public String getAuthority() {
        return name;
    }
}
