package com.xb.mapper;

import com.xb.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentMapper extends Mapper<Comment> {

    /**
     * 根据博客id查找主评论
     * @param blogId 博客id
     * @return 主评论列表
     */
    @Select("SELECT * FROM t_comment WHERE blogId = #{blogId} AND parentId = 0")
    List<Comment> findFirstParentByBlogId(Integer blogId);

    /**
     * 根据主评论id查找回复
     * @param id 主评论id
     * @return 回复评论信息
     */
    @Select("SELECT * FROM t_comment WHERE parentId = #{id}")
    List<Comment> findCommentByParentId(Long id);

    /**
     * 添加评论
     * @param comment 评论信息
     */
    @Insert("INSERT INTO t_comment (nickname,email,content,avatar,createTime,blogId,parentId) values " +
            "(#{nickname},#{email},#{content},#{avatar},#{createTime},#{blogId},#{parentId})")
    void addComment(Comment comment);
}
