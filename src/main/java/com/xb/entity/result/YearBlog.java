package com.xb.entity.result;

import com.xb.entity.Blog;

import java.io.Serializable;
import java.util.List;

public class YearBlog implements Serializable {

    private String year;

    private List<Blog> blogList;

    public YearBlog() {
    }

    public YearBlog(String year, List<Blog> blogList) {
        this.year = year;
        this.blogList = blogList;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
