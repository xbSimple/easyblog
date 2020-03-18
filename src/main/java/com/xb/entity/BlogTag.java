package com.xb.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;

@Table(name = "t_blog_tag")
public class BlogTag implements Serializable {

    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private Long id;

    @Column(name = "blogId", type = MySqlTypeConstant.BIGINT)
    private Long blogId;

    @Column(name = "tagId", type = MySqlTypeConstant.BIGINT)
    private Long tagId;

    public BlogTag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "BlogTag{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", tagId=" + tagId +
                '}';
    }
}