package com.dw.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dw.dict.RoleEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author yangjunxiong
 * @since 2019-12-15 12:47:38
 */
@TableName("t_user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 738444262437487165L;

    // ---> 数据库字段开始
    //@TableId(value = "id", type = IdType.ID_WORKER)//雪花id
    //主键
    private Long id;

    //用户名
    private String userName;

    //密码
    private String password;

    //角色
    private RoleEnum role;

    // ---> 数据库字段结束

    // ---> 业务字段开始
    //@TableField(exist = false)


    // ---> 业务字段结束

    // ---> getter setter


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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}