package com.xb.mapper;

import com.xb.entity.Blog;
import com.xb.entity.result.ResultBlog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BlogMapper extends Mapper<Blog> {

    /**
     * 查找已发表的博客包括用户昵称、分类名称及标签
     * @return 已发表博客列表
     */
    List<ResultBlog> findResultBlog();

    /**
     * 查找推荐的博客
     * @return 博客id和标题
     */
    @Select("SELECT id,title FROM t_blog WHERE published=1 AND recommend=1 ORDER BY createTime DESC LIMIT 0,4")
    List<Blog> findRecommendBlog();

    /**
     * 查找最新的博客
     * @return 博客id和标题
     */
    @Select("SELECT id,title FROM t_blog WHERE published=1 ORDER BY createTime DESC LIMIT 0,3")
    List<Blog> findNewBlog();


    /**
     * 根据分类名称查找博客
     * @param type 分类名称
     * @return 选择分类的博客列表
     */
    @Select(" SELECT b.*,t.name as typeName,u.nickname as nickName FROM t_blog b LEFT JOIN t_type t ON b.typeId=t.id LEFT JOIN t_user u ON b.userId=u.id WHERE published=1 AND t.name=#{type}")
    List<ResultBlog> findBlogByType(String type);

    /**
     * 根据标签名称查找博客
     * @param tag 标签名称
     * @return 选择标签的博客列表
     */
    @Select("SELECT b.*,t.name as typeName,u.nickname as nickName FROM t_blog b LEFT JOIN t_type t ON b.typeId=t.id " +
            "LEFT JOIN t_user u ON b.userId=u.id WHERE b.id in (SELECT bt.blogId FROM t_blog_tag bt,t_tag t WHERE published=1 AND bt.tagId=t.id AND t.name=#{tag})")
    List<ResultBlog> findBlogByTag(String tag);

    /**
     * 查找所有博客所处的年份列表
     * @return 年份列表
     */
    @Select("SELECT DATE_FORMAT(b.createTime,'%Y') AS year FROM t_blog b GROUP BY year ORDER BY year DESC")
    List<String> findGroupYear();

    /**
     * 根据年份查找各年份的博客
     * @param year 年份
     * @return 博客列表
     */
    @Select("SELECT * FROM t_blog WHERE DATE_FORMAT(createTime,'%Y')=#{year} AND published = 1 ")
    List<Blog> findBlogByYear(String year);


    /**
     *
     * @param title 标题
     * @param typeId 分类id
     * @param recommend 是否推荐
     * @return 搜索到的博客列表
     */
    List<ResultBlog> searchBlog(@Param("title") String title,@Param("typeId") int typeId,@Param("recommend") int recommend);


    /**
     * 根据id删除博客
     * @param id 博客id
     */
    @Delete("DELETE FROM t_blog WHERE id = #{id}")
    void deleteById(int id);

    /**
     * 根据id查询博客
     * @param id 博客id
     * @return 查询到的博客
     */
    @Select("SELECT b.*,t.name as typeName,u.nickname as nickName FROM t_blog b LEFT JOIN t_type t ON b.typeId=t.id LEFT JOIN t_user u ON b.userId=u.id WHERE b.id = #{id} ")
    ResultBlog findBlogById(int id);

    /**
     * 新增博客
     * @param blog 博客内容
     */
    void addBlog(Blog blog);

    /**
     * 编辑更新博客
     * @param blog 博客内容
     */
    void updateBlog(Blog blog);

    /**
     * 根据分类id查询博客数量
     * @param id 分类id
     * @return 博客数量
     */
    @Select("SELECT count(*) FROM t_blog WHERE published=1 AND typeId=#{id}")
    int countBlogByTypeId(Long id);

    /**
     * 分页查找所有博客包括用户昵称、分类名称及标签
、     * @return 所有博客列表
     */
    List<ResultBlog> findAllResultBlog();
}
