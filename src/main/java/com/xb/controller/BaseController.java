package com.xb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    /**
     * 页面跳转
     * @return 主页
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    /**
     * 页面跳转
     * @return 博客页面
     */
    @RequestMapping("/blog")
    public String blog(){
        return "blog";
    }


    /**
     * 页面跳转
     * @return 分类页面
     */
    @RequestMapping("/types")
    public String types(){
        return "types";
    }


    /**
     * 页面跳转
     * @return 标签页面
     */
    @RequestMapping("/tags")
    public String tags(){
        return "tags";
    }


    /**
     * 页面跳转
     * @return 归档页面
     */
    @RequestMapping("/archives")
    public String archives(){
        return "archives";
    }


    /**
     * 页面跳转
     * @return 关于我页面
     */
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

}
