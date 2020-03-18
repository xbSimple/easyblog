package com.xb.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;

@Table(name = "t_blog")
public class Blog implements Serializable {

    @Column(name = "id",type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true)
    private Long id;

    @Column(name = "title",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String  title;

    @Column(name = "content",type = MySqlTypeConstant.TEXT)
    private String  content;

    @Column(name = "contentText",type = MySqlTypeConstant.TEXT)
    private String  contentText;

    @Column(name = "firstPicture",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String    firstPicture;

    @Column(name = "flag",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String  flag;

    @Column(name = "views",type = MySqlTypeConstant.INT,length = 10)
    private Integer  views;

    @Column(name = "appreciation",type = MySqlTypeConstant.INT,length = 1)
    private Integer  appreciation;

    @Column(name = "shareStatement",type = MySqlTypeConstant.INT,length = 1)
    private Integer  shareStatement;

    @Column(name = "commentabled",type = MySqlTypeConstant.INT,length = 1)
    private Integer  commentabled;

    @Column(name = "published",type = MySqlTypeConstant.INT,length = 1)
    private Integer  published;

    @Column(name = "recommend",type = MySqlTypeConstant.INT,length = 1)
    private Integer  recommend;

    @Column(name = "createTime",type = MySqlTypeConstant.DATETIME)
    private String createTime;

    @Column(name = "updateTime",type = MySqlTypeConstant.DATETIME)
    private String updateTime;

    @Column(name = "typeId",type = MySqlTypeConstant.BIGINT)
    private Long typeId;

    @Column(name = "userId",type = MySqlTypeConstant.BIGINT)
    private Long userId;

    public Blog() {
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Integer appreciation) {
        this.appreciation = appreciation;
    }

    public Integer getShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(Integer shareStatement) {
        this.shareStatement = shareStatement;
    }

    public Integer getCommentabled() {
        return commentabled;
    }

    public void setCommentabled(Integer commentabled) {
        this.commentabled = commentabled;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", contentText='" + contentText + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", typeId=" + typeId +
                ", userId=" + userId +
                '}';
    }
}
