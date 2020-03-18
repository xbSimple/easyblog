package com.xb.entity.result;


import java.io.Serializable;
import java.util.List;

public class BlogSearch implements Serializable {

    private List<ResultBlog> resultBlogs;

    private Integer totalBlog;

    public BlogSearch() {
    }

    public BlogSearch(List<ResultBlog> resultBlogs, Integer totalBlog) {
        this.resultBlogs = resultBlogs;
        this.totalBlog = totalBlog;
    }

    public List<ResultBlog> getResultBlogs() {
        return resultBlogs;
    }

    public void setResultBlogs(List<ResultBlog> resultBlogs) {
        this.resultBlogs = resultBlogs;
    }

    public Integer getTotalBlog() {
        return totalBlog;
    }

    public void setTotalBlog(Integer totalBlog) {
        this.totalBlog = totalBlog;
    }
}
