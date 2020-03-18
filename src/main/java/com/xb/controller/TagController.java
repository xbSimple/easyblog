package com.xb.controller;

import com.xb.entity.Tag;
import com.xb.entity.Type;
import com.xb.entity.result.TagAndNums;
import com.xb.entity.result.TagPage;
import com.xb.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 查找标签及该标签下的博客数量
     * @return 标签及该标签下的博客数量
     */
    @RequestMapping("/findTagAndNums")
    public List<TagAndNums> findTypeAndNums(){
        return tagService.findTagAndNums();
    }

    /**
     * 查找所有的标签
     * @return 标签列表
     */
    @RequestMapping("/findAllTag")
    public List<Tag> findAllTag(){
        return tagService.findAllTag();
    }

    /**
     * 分页查找标签
     * @param pageNum 页码
     * @return 当前页码下的标签列表
     */
    @RequestMapping("/findTagPage/{pageNum}")
    public TagPage findTagPage(@PathVariable int pageNum){
        return tagService.findTagPage(pageNum);
    }

    /**
     * 根据id删除标签
     * @param id 标签id
     */
    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id){
        tagService.deleteTag(id);
    }

    /**
     * 更新或新增标签
     * @param tag 标签名称
     * @return 是否添加成功
     */
    @PostMapping("/addTag")
    public boolean addTag(@RequestBody Map<String,Object> tag ){
        tagService.addTag(tag);
        return true;
    }

    /**
     * 根据id查询标签
     * @param id 标签id
     * @return 标签内容
     */
    @RequestMapping("/findTagById")
    public Tag findTagById(@RequestParam("id") int id){
        return tagService.findTagById(id);
    }
}
