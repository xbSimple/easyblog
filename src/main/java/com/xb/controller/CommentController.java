package com.xb.controller;

import com.xb.entity.Comment;
import com.xb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 根据博客id查找博客的评论
     * @param blogId 博客id
     * @return 评论列表
     */
    @RequestMapping("/findAllCommentById")
    public List<Comment> findAllCommentById(@RequestParam("blogId") Integer blogId){
        return commentService.findAllCommentByBlogId(blogId);
    }

    /**
     * 添加评论
     * @param comment 评论信息
     * @return 添加是否成功
     */
    @PostMapping("/addComment")
    public boolean addComment(@RequestBody Map<String,Object> comment ) {
        commentService.addComment(comment);
        return true;
    }
}
