package com.xb.entity.result;


import com.xb.entity.Tag;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ResultBlog implements Serializable {

    private Long id;

    private String  title;

    private String  content;

    private String  contentText;

    private String  firstPicture;

    private String  flag;

    private Integer  views;

    private Integer  appreciation;

    private Integer  shareStatement;

    private Integer  commentabled;

    private Integer  published;

    private Integer  recommend;

    private Date createTime;

    private Date  updateTime;

    private Long typeId;

    private Long userId;

    private String typeName;

    private String nickName;

    private List<Tag> tags;

    public ResultBlog() {
    }

    public ResultBlog(Long id, String title, String content, String contentText, String firstPicture, String flag, Integer views, Integer appreciation, Integer shareStatement, Integer commentabled, Integer published, Integer recommend, Date createTime, Date updateTime, Long typeId, Long userId, String typeName, String nickName, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.contentText = contentText;
        this.firstPicture = firstPicture;
        this.flag = flag;
        this.views = views;
        this.appreciation = appreciation;
        this.shareStatement = shareStatement;
        this.commentabled = commentabled;
        this.published = published;
        this.recommend = recommend;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.typeId = typeId;
        this.userId = userId;
        this.typeName = typeName;
        this.nickName = nickName;
        this.tags = tags;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
