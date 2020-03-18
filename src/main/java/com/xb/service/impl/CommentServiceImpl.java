package com.xb.service.impl;


import com.xb.entity.Comment;
import com.xb.mapper.CommentMapper;
import com.xb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 根据博客id查找博客的评论
     * @param blogId 博客id
     * @return 评论列表
     */
    @Override
    public List<Comment> findAllCommentByBlogId(Integer blogId) {
        List<Comment> commentList = commentMapper.findFirstParentByBlogId(blogId);
        List<Comment> commentList1 = new ArrayList<>();
        for (Comment comment :commentList) {
            comment = findChildrenComment(comment);
            commentList1.add(comment);
        }
        System.out.println(commentList1);
        return commentList1;
    }

    /**
     * 查找主评论下的回复
     * @param comment 主评论
     * @return 主评论信息
     */
    public  Comment findChildrenComment(Comment comment) {
        List<Comment> commentChildren = commentMapper.findCommentByParentId(comment.getId());
        comment.setCommentChildren(commentChildren);
        while (commentChildren.size()>0){
            for (Comment comment1:commentChildren) {
                findChildrenComment(comment1);
            }
            return comment;
        }
        return comment;
    }

    /**
     * 添加评论
     * @param comment 评论信息
     */
    @Override
    public void addComment(Map<String, Object> comment) {
        Comment comment1= new Comment();
        comment1.setAvatar("https://unsplash.it/100/100?image=1005");
        comment1.setCreateTime(new Date());
        comment1.setContent(comment.get("content").toString());
        comment1.setEmail(comment.get("email").toString());
        comment1.setNickname(comment.get("nickname").toString());
        comment1.setBlogId(Long.valueOf(comment.get("blogId").toString()));
        comment1.setParentId(Long.valueOf(comment.get("parentId").toString()));
        commentMapper.addComment(comment1);
    }
}
