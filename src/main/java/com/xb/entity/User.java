package com.xb.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;
import java.util.Date;

@Table(name = "t_user")
public class User implements Serializable {

    @Column(name = "id",type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true)
    private Long id;

    @Column(name = "nickname",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String  nickname;

    @Column(name = "username",type = MySqlTypeConstant.VARCHAR,length = 30)
    private String  username;

    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String  password;

    @Column(name = "email",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String  email;

    @Column(name = "avatar",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String  avatar;

    @Column(name = "type",type = MySqlTypeConstant.INT)
    private Integer  type;

    @Column(name = "createTime",type = MySqlTypeConstant.DATETIME)
    private Date createTime;

    @Column(name = "updateTime",type = MySqlTypeConstant.DATETIME)
    private Date updateTime;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
