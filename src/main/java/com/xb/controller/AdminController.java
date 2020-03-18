package com.xb.controller;

import com.xb.entity.User;
import com.xb.entity.result.LoginMessage;
import com.xb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    /**
     * 页面跳转
     * @return 博客管理页面
     */
    @RequestMapping("/blogs")
    public String blogs(){
        return "/admin/blogs";
    }

    /**
     * 页面跳转
     * @return 博客编辑发布页面
     */
    @RequestMapping("/blog-input")
    public String blogInput(){
        return "/admin/blog-input";
    }

    /**
     * 页面跳转
     * @return 博客分类管理页面
     */
    @RequestMapping("/typesm")
    public String typesm(){
        return "/admin/typesm";
    }

    /**
     * 页面跳转
     * @return 博客分类添加页面
     */
    @RequestMapping("/type-input")
    public String typeInput(){
        return "/admin/type-input";
    }

    /**
     * 页面跳转
     * @return 博客标签管理页面
     */
    @RequestMapping("/tagsm")
    public String tagsm(){
        return "/admin/tagsm";
    }

    /**
     * 页面跳转
     * @return 博客标签添加页面
     */
    @RequestMapping("/tag-input")
    public String tagInput(){
        return "/admin/tag-input";
    }

    /**
     * 用户登录
     * @return 用户登录页面
     */
    @RequestMapping
    public String loginPage(){
        return "/admin/login";
    }

    /**
     * 登录验证
     * @param user1 登录用户信息
     * @param session 存储登录状态
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public LoginMessage login(@RequestBody Map<String,String> user1,
                              HttpSession session
                        ){
        User user = userService.checkUser(user1.get("username"),user1.get("password"));
        LoginMessage loginMessage = new LoginMessage();
        if (user != null){
            user.setPassword(null);
            session.setAttribute("user",user);
            loginMessage.setUrl("/admin/blogs");
            loginMessage.setMessage("登陆成功");
        }else {
            loginMessage.setUrl("/admin");
            loginMessage.setMessage("用户名或密码不正确");
        }
        return loginMessage;
    }

    /**
     * 用户登出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
