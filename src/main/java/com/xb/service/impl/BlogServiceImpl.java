package com.xb.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xb.entity.Blog;
import com.xb.entity.BlogTag;
import com.xb.entity.result.*;
import com.xb.entity.Tag;
import com.xb.mapper.BlogMapper;

import com.xb.mapper.BlogTagMapper;
import com.xb.mapper.TagMapper;
import com.xb.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查找已发表的博客包括用户昵称、分类名称及标签
     * @return 已发表博客列表
     */
    public List<ResultBlog> findResultBlog() {

//        List<ResultBlog> resultBlogList = (List<ResultBlog>) redisTemplate.boundValueOps("resultBlog").get();
//        if (resultBlogList!=null){
//            System.out.println("从缓存获取ResultBlog");
//            return resultBlogList;
//        }
        List<ResultBlog> resultBlogList = blogMapper.findResultBlog();

        for (ResultBlog resultBlog:resultBlogList) {
            List<Tag> tags = tagMapper.findTagsByBlogId(resultBlog.getId());
            resultBlog.setTags(tags);
        }
//        redisTemplate.boundValueOps("resultBlog").set(resultBlogList);
        return resultBlogList;
    }

    /**
     * 查找推荐的博客
     * @return 博客id和标题
     */
    @Override
    public List<Blog> findRecommendBlog() {
//        List<Blog> recommendBlogList = (List<Blog>) redisTemplate.boundValueOps("recommendBlog").get();
//        if (recommendBlogList!=null){
//            System.out.println("从缓存获取recommendBlog");
//            return recommendBlogList;
//        }
        List<Blog> recommendBlogList = blogMapper.findRecommendBlog();

//        redisTemplate.boundValueOps("recommendBlog").set(recommendBlogList);
        return recommendBlogList;    }

    /**
     * 查找最新的博客
     * @return 博客id和标题
     */
    @Override
    public List<Blog> findNewBlog() {
//        List<Blog> newBlogList = (List<Blog>) redisTemplate.boundValueOps("newBlog").get();
//        if (newBlogList!=null){
//            System.out.println("从缓存获取newBlog");
//            return newBlogList;
//        }
        List<Blog> newBlogList = blogMapper.findNewBlog();

//        redisTemplate.boundValueOps("newBlog").set(newBlogList);
        return newBlogList;
    }

    /**
     * 分页查找已发表的博客包括用户昵称、分类名称及标签
     * @param pageNum 页码
     * @return 当前页码博客及博客总数
     */
    @Override
    public BlogPage findBlogPage(int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<ResultBlog> blogList = blogMapper.findResultBlog();
        int total = (int) new PageInfo<ResultBlog>(blogList).getTotal();
        BlogPage blogPage = new BlogPage(blogList,total);
        return blogPage;
    }

    /**
     * 分页查找所有博客包括用户昵称、分类名称及标签
     * @param pageNum 页码
     * @return 当前页码博客及博客总数
     */
    @Override
    public BlogPage findAllBlogPage(int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<ResultBlog> blogList = blogMapper.findAllResultBlog();
        int total = (int) new PageInfo<ResultBlog>(blogList).getTotal();
        BlogPage blogPage = new BlogPage(blogList,total);
        return blogPage;
    }

    /**
     * 根据标签名称分页查找博客
     * @param tag 标签名称
     * @param page 页码
     * @return 选择标签的当前页码博客及博客总数
     */
    @Override
    public BlogPage findBlogByTag(String tag, int page) {
        PageHelper.startPage(page,10);
        List<ResultBlog> blogList = blogMapper.findBlogByTag(tag);
        int total = (int) new PageInfo<ResultBlog>(blogList).getTotal();
        for (ResultBlog resultBlog:blogList) {
            List<Tag> tags = tagMapper.findTagsByBlogId(resultBlog.getId());
            resultBlog.setTags(tags);
        }
        BlogPage blogPage = new BlogPage(blogList,total);
        return blogPage;
    }

    /**
     * 根据分类名称分页查找博客
     * @param type 分类名称
     * @param page 页码
     * @return 选择分类的当前页码博客及博客总数
     */
    @Override
    public BlogPage findBlogByType(String type, int page) {
        PageHelper.startPage(page,10);
        List<ResultBlog> blogList = blogMapper.findBlogByType(type);
        int total = (int) new PageInfo<ResultBlog>(blogList).getTotal();
        BlogPage blogPage = new BlogPage(blogList,total);
        return blogPage;
    }

    /**
     * 查询归档博客列表
     * @return 博客总数及按时间分类博客列表
     */
    @Override
    public ArchivesBlog findBlogByDate() {
        List<String> yearList = blogMapper.findGroupYear();
        ArchivesBlog archivesBlog=new ArchivesBlog();
        List<YearBlog> yearBlogList=new ArrayList<>();

        int total =0;
        for (String year:yearList) {
            List<Blog> blogList = blogMapper.findBlogByYear(year);
            YearBlog yearBlog= new YearBlog();
            yearBlog.setYear(year);
            yearBlog.setBlogList(blogList);
            yearBlogList.add(yearBlog);
            total += blogList.size();
        }
        archivesBlog.setTotal(total);
        archivesBlog.setYearBlogList(yearBlogList);
        return archivesBlog;
    }

    /**
     * 根据id查询博客
     * @param id 博客id
     * @return 查询到的博客
     */
    @Override
    public ResultBlog findBlogById(int id) {
        ResultBlog resultBlog = blogMapper.findBlogById(id);
        List<Tag> tagList = tagMapper.findTagsByBlogId((long) id);
        resultBlog.setTags(tagList);
        return resultBlog;
    }

    /**
     * 根据id删除博客
     * @param id 博客id
     */
    @Override
    public void deleteBlog(int id) {
        blogMapper.deleteById(id);
    }

    /**
     *
     * @param title 标题
     * @param typeId 分类id
     * @param recommend 是否推荐
     * @return 搜索到的博客列表及数量
     */
    @Override
    public BlogSearch searchBlog(String title, int typeId, Boolean recommend) {
        int recommend1 = 0;
        if (recommend==true){
            recommend1 = 1;
        }
        if (title.length()<1){
            title = null;
        }else {
            title = "%"+title+"%";
        }
        List<ResultBlog> resultBlogs = blogMapper.searchBlog(title, typeId, recommend1);
        BlogSearch blogSearch = new BlogSearch(resultBlogs,resultBlogs.size());

        return blogSearch;
    }

    @Autowired
    private BlogTagMapper blogTagMapper;

    /**
     * 编辑或新增博客
     * @param blog 博客内容
     */
    @Override
    public void addBlog(Map<String, Object> blog){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String date = sdf.format(new Date());
        Blog blog1 = new Blog();
        blog1.setTitle(blog.get("title").toString());
        blog1.setContent(blog.get("content").toString());
        blog1.setContentText(blog.get("contentText").toString());
        blog1.setUpdateTime(date);
        blog1.setFlag(blog.get("flag").toString());
        blog1.setFirstPicture(blog.get("firstImage").toString());
        blog1.setPublished(Integer.parseInt(blog.get("published").toString()));
        blog1.setUserId((long) 1);
        blog1.setTypeId((long) Integer.parseInt(blog.get("type").toString()));
        String check = blog.get("check").toString();
        if (check.contains("推荐")){
            blog1.setRecommend(1);
        }else {
            blog1.setRecommend(0);
        }
        if (check.contains("转载声明")){
            blog1.setShareStatement(1);
        }else {
            blog1.setShareStatement(0);
        }
        if (check.contains("评论")){
            blog1.setCommentabled(1);
        }else {
            blog1.setCommentabled(0);
        }
        if (check.contains("赞赏")){
            blog1.setAppreciation(1);
        }else {
            blog1.setAppreciation(0);
        }
        Object id = blog.get("id");
        if (id != null && !"".equals(id.toString())){
            blog1.setId((long)Integer.parseInt(id.toString()));
            blogMapper.updateBlog(blog1);
            Long blogId = blog1.getId();
            blogTagMapper.deleteBlogTag(blogId);
        }else {
            blog1.setCreateTime(date);
            blogMapper.addBlog(blog1);
        }
        Long blogId = blog1.getId();
        String[] tagArray = blog.get("tags").toString().replace("[", "").replace("]", "").split(",");
        for (int i=0;i<tagArray.length;i++){
            Long tagId = (long) Integer.parseInt(tagArray[i].trim());
            BlogTag blogTag = new BlogTag();
            blogTag.setBlogId(blogId);
            blogTag.setTagId(tagId);
            blogTagMapper.addBlogTag(blogTag);
        }

    }
}
