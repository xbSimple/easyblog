package com.xb.controller;

import com.xb.entity.Blog;
import com.xb.entity.result.ArchivesBlog;
import com.xb.entity.result.BlogPage;
import com.xb.entity.result.BlogSearch;
import com.xb.entity.result.ResultBlog;
import com.xb.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 查找已发表的博客包括用户昵称、分类名称及标签
     * @return 已发表博客列表
     */
    @RequestMapping("/findResultBlog")
    public List<ResultBlog> findResultBlog(){
        return blogService.findResultBlog();
    }


    /**
     * 查找推荐的博客
     * @return 博客id和标题
     */
    @RequestMapping("/findRecommendBlog")
    public List<Blog> findRecommendBlog(){
        return blogService.findRecommendBlog();
    }

    /**
     * 查找最新的博客
     * @return 博客id和标题
     */
    @RequestMapping("/findNewBlog")
    public List<Blog> findNewBlog(){
        return blogService.findNewBlog();
    }

    /**
     * 分页查找已发表的博客包括用户昵称、分类名称及标签
     * @param pageNum 页码
     * @return 当前页码博客及博客总数
     */
    @RequestMapping("/findBlogPage/{pageNum}")
    public BlogPage findBlogPage(@PathVariable int pageNum){
        return blogService.findBlogPage(pageNum);
    }

    /**
     * 分页查找所有博客包括用户昵称、分类名称及标签
     * @param pageNum 页码
     * @return 当前页码博客及博客总数
     */
    @RequestMapping("/findAllBlogPage/{pageNum}")
    public BlogPage findAllBlogPage(@PathVariable int pageNum){
        return blogService.findAllBlogPage(pageNum);
    }

    /**
     * 根据分类名称分页查找博客
     * @param type 分类名称
     * @param page 页码
     * @return 选择分类的当前页码博客及博客总数
     */
    @RequestMapping("/findBlogByType")
    public BlogPage findBlogByType(@RequestParam("type") String type,@RequestParam("page") int page){

        return blogService.findBlogByType(type,page);
    }

    /**
     * 根据标签名称分页查找博客
     * @param tag 标签名称
     * @param page 页码
     * @return 选择标签的当前页码博客及博客总数
     */
    @RequestMapping("/findBlogByTag")
    public BlogPage findBlogByTag(@RequestParam("tag") String tag,@RequestParam("page") int page){

        return blogService.findBlogByTag(tag,page);
    }

    /**
     * 查询归档博客列表
     * @return 博客总数及按时间分类博客列表
     */
    @RequestMapping("/findBlogByDate")
    public ArchivesBlog findBlogByDate(){
        return blogService.findBlogByDate();
    }

    /**
     *
     * @param title 标题
     * @param typeId 分类id
     * @param recommend 是否推荐
     * @return 搜索到的博客列表及数量
     */
    @RequestMapping("/searchBlog")
    public BlogSearch searchBlog(@RequestParam("title") String title, @RequestParam("typeId") String typeId, @RequestParam("recommend") Boolean recommend){
        int typeId1 = 0;
        if (typeId!=null && !typeId.equals("")) {
            typeId1 = Integer.parseInt(typeId);
        }
        return blogService.searchBlog(title,typeId1,recommend);
    }

    /**
     * 根据id删除博客
     * @param id 博客id
     */
    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id){
        blogService.deleteBlog(id);
    }

    /**
     * 根据id查询博客
     * @param id 博客id
     * @return 查询到的博客
     */
    @RequestMapping("/findBlogById")
    public ResultBlog findBlogById(@RequestParam("id") int id){
        return blogService.findBlogById(id);
    }

    /**
     * 编辑或新增博客
     * @param blog 博客内容
     * @return 添加是否成功
     */
    @PostMapping("/addBlog")
    public boolean addBlog(@RequestBody Map<String,Object> blog ) {
        blogService.addBlog(blog);
        return true;
    }
}
