package com.xb.service;

import com.xb.entity.Blog;
import com.xb.entity.result.ArchivesBlog;
import com.xb.entity.result.BlogPage;
import com.xb.entity.result.BlogSearch;
import com.xb.entity.result.ResultBlog;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface BlogService {
    List<ResultBlog> findResultBlog();

    List<Blog> findRecommendBlog();

    List<Blog> findNewBlog();

    BlogPage findBlogPage(int pageNum);

    BlogPage findBlogByType(String type, int page);

    BlogPage findBlogByTag(String tag, int page);

    ArchivesBlog findBlogByDate();

    BlogSearch searchBlog(String title, int typeId, Boolean recommend);

    void deleteBlog(int id);

    ResultBlog findBlogById(int id);

    void addBlog(Map<String, Object> blog);

    BlogPage findAllBlogPage(int pageNum);
}
