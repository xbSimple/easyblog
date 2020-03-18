package com.xb.controller;

import com.xb.entity.Type;
import com.xb.entity.result.TypeAndNums;
import com.xb.entity.result.TypePage;
import com.xb.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 查找分类及该分类下的博客数量
     * @return 分类及该分类下的博客数量
     */
    @RequestMapping("/findTypeAndNums")
    public List<TypeAndNums> findTypeAndNums(){
        return typeService.findTypeAndNums();
    }

    /**
     * 查找所有的分类
     * @return 分类列表
     */
    @RequestMapping("/findAllType")
    public List<Type> findAllType(){
        return typeService.findAllType();
    }

    /**
     * 分页查找分类
     * @param pageNum 页码
     * @return 当前页码下的分类列表
     */
    @RequestMapping("/findTypePage/{pageNum}")
    public TypePage findTypePage(@PathVariable int pageNum){
        return typeService.findTypePage(pageNum);
    }

    /**
     * 根据id删除分类
     * @param id 分类id
     */
    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id){
        typeService.deleteType(id);
    }

    /**
     * 更新或新增分类
     * @param type 分类内容
     * @return 是否成功
     */
    @PostMapping("/addType")
    public boolean addType(@RequestBody Map<String,Object> type ){
        typeService.addType(type);
        return true;
    }

    /**
     * 根据分类id查找分类
     * @param id 分类id
     * @return 分类内容
     */
    @RequestMapping("/findTypeById")
    public Type findTypeById(@RequestParam("id") int id){
        return typeService.findTypeById(id);
    }
}
