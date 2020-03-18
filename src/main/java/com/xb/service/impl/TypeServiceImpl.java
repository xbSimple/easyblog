package com.xb.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xb.entity.Type;
import com.xb.entity.result.TypeAndNums;
import com.xb.entity.result.TypePage;
import com.xb.mapper.BlogMapper;
import com.xb.mapper.TypeMapper;
import com.xb.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查找分类及该分类下的博客数量
     * @return 分类及该分类下的博客数量
     */
    @Override
    public List<TypeAndNums> findTypeAndNums() {
//        List<TypeAndNums> typeAndNumsList = (List<TypeAndNums>) redisTemplate.boundValueOps("typeAndNums").get();
//        if (typeAndNumsList!=null){
//            System.out.println("从缓存获取TypeAndNums");
//            return typeAndNumsList;
//        }
        List<Type> allType = typeMapper.findAllType();
        List<TypeAndNums> typeAndNumsList =new ArrayList<>();
        for (Type type:allType) {
            int blogNum = blogMapper.countBlogByTypeId(type.getId());
            TypeAndNums typeAndNums = new TypeAndNums(blogNum,type.getName());
            typeAndNumsList.add(typeAndNums);
        }

//        List<TypeAndNums> typeAndNumsList = typeMapper.findTypeAndNums();
//        redisTemplate.boundValueOps("typeAndNums").set(typeAndNumsList);
        return typeAndNumsList;
    }

    /**
     * 查找所有的分类
     * @return 分类列表
     */
    @Override
    public List<Type> findAllType() {
        return typeMapper.findAllType();
    }

    /**
     * 分页查找分类
     * @param pageNum 页码
     * @return 当前页码下的分类列表
     */
    @Override
    public TypePage findTypePage(int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Type> types = typeMapper.findAllType();
        int total = (int) new PageInfo<Type>(types).getTotal();
        TypePage typePage = new TypePage(types,total);
        return typePage;
    }

    /**
     * 根据id删除分类
     * @param id 分类id
     */
    @Override
    public void deleteType(int id) {
        typeMapper.deleteType(id);
    }

    /**
     * 更新或新增分类
     * @param type 分类内容
     */
    @Override
    public void addType(Map<String, Object> type) {
        Type type1 = new Type();
        type1.setName(type.get("name").toString());
        Object id = type.get("id");
        if (id != null && !"".equals(id.toString())){
            type1.setId((long) Integer.parseInt(id.toString()));
            typeMapper.updateType(type1);
        }else {
            typeMapper.addType(type1);
        }
    }

    /**
     * 根据分类id查找分类
     * @param id 分类id
     * @return 分类内容
     */
    @Override
    public Type findTypeById(int id) {
        return typeMapper.findTypeById(id);
    }
}
