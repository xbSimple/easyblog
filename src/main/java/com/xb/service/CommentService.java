package com.xb.service;

import com.xb.entity.Comment;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Comment> findAllCommentByBlogId(Integer blogId);

    void addComment(Map<String, Object> comment);
}
