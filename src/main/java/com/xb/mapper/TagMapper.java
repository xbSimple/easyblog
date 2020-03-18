package com.xb.mapper;

import com.xb.entity.Tag;
import com.xb.entity.result.TagAndNums;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TagMapper extends Mapper<Tag> {

    /**
     * 根据博客id查询标签列表
     * @param id 博客id
     * @return 标签类表
     */
    @Select("SELECT * FROM t_tag WHERE id in (SELECT tagId FROM t_blog_tag WHERE blogId = #{id})")
    List<Tag> findTagsByBlogId(Long id);

    /**
     * 查找标签及该标签下的博客数量
     * @return 标签及该标签下的博客数量
     */
    @Select("SELECT count(*) AS nums,t.name AS tagName FROM t_blog b LEFT JOIN t_blog_tag bt ON b.id=bt.blogId LEFT JOIN t_tag t ON bt.tagId=t.id GROUP BY t.name")
    List<TagAndNums> findTagAndNums();

    /**
     * 查找所有标签
     * @return 标签列表
     */
    @Select("SELECT * FROM t_tag")
    List<Tag> findAllTag();

    /**
     * 根据id删除标签
     * @param id 标签id
     */
    @Delete("DELETE FROM t_tag WHERE id = #{id}")
    void deleteTag(int id);

    /**
     * 更新标签
     * @param tag 标签名称
     */
    @Update("UPDATE t_tag SET name = #{name} WHERE id = #{id}")
    void updateTag(Tag tag);

    /**
     * 添加标签
     * @param tag 标签名称
     */
    @Insert("INSERT INTO t_tag (name) values (#{name})")
    void addTag(Tag tag);

    /**
     * 根据id查询标签
     * @param id 标签id
     * @return 标签内容
     */
    @Select("SELECT * FROM t_tag WHERE id=#{id}")
    Tag findTagById(int id);
}
