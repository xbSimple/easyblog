package com.xb.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name="t_comment")
public class Comment implements Serializable {

    @Column(name = "id",type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true)
    private Long id;

    @Column(name = "nickname",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String  nickname;

    @Column(name = "email",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String  email;

    @Column(name = "content",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String  content;

    @Column(name = "avatar",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String  avatar;

    @Column(name = "createTime",type = MySqlTypeConstant.DATETIME)
    private Date createTime;

    @Column(name = "blogId",type = MySqlTypeConstant.BIGINT)
    private Long blogId;

    @Column(name = "parentId",type = MySqlTypeConstant.BIGINT)
    private Long parentId;

    private List<Comment> commentChildren;

    public List<Comment> getCommentChildren() {
        return commentChildren;
    }

    public void setCommentChildren(List<Comment> commentChildren) {
        this.commentChildren = commentChildren;
    }

    public Comment() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", blogId=" + blogId +
                ", parentId=" + parentId +
                ", commentChildren=" + commentChildren +
                '}';
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
