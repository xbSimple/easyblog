package com.xb.entity.result;

import com.xb.entity.Blog;

import java.io.Serializable;
import java.util.List;

public class ArchivesBlog implements Serializable {

    private List<YearBlog> yearBlogList;

    private int total;

    public ArchivesBlog() {
    }

    public ArchivesBlog(List<YearBlog> yearBlogList, int total) {
        this.yearBlogList = yearBlogList;
        this.total = total;
    }

    public List<YearBlog> getYearBlogList() {
        return yearBlogList;
    }

    public void setYearBlogList(List<YearBlog> yearBlogList) {
        this.yearBlogList = yearBlogList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
