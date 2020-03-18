package com.xb.mapper;

import com.xb.entity.BlogTag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface BlogTagMapper extends Mapper<BlogTag> {

    /**
     * 添加博客及标签对应信息
     * @param blogTag 博客标签对应信息
     */
    @Insert("INSERT INTO t_blog_tag (blogId,tagId) values (#{blogId},#{tagId})")
    void addBlogTag(BlogTag blogTag);

    /**
     * 根据标签id查询博客数量
     * @param id 标签id
     * @return 博客数量
     */
    @Select("SELECT count(*) FROM t_blog b LEFT JOIN t_blog_tag bt ON b.id=bt.blogId WHERE published=1 AND tagId=#{id}")
    int countBlogByTagId(Long id);

    /**
     * 根据博客id删除标签
     * @param blogId 博客id
     */
    @Delete("DELETE FROM t_blog_tag WHERE blogId=#{blogId}")
    void deleteBlogTag(Long blogId);
}
