package com.dw.controller.model;


import com.dw.controller.common.verify.Verify;
import com.dw.dict.RoleEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author yangjunxiong
 * @since 2019-12-15 13:08:05
 */
public class UserVo implements Verify, Serializable {
    private static final long     serialVersionUID = -94189177061834526L;
    //主键
    private              Long     id;
    //用户名
    @NotBlank(message = "账号不能为空")
    private              String   userName;
    //密码
    @NotBlank(message = "密码不能为空")
    private              String   password;
    //角色
    private              RoleEnum role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}