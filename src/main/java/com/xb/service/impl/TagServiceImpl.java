package com.xb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xb.entity.Tag;
import com.xb.entity.result.TagAndNums;
import com.xb.entity.result.TagPage;
import com.xb.mapper.BlogTagMapper;
import com.xb.mapper.TagMapper;
import com.xb.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查找所有的标签
     * @return 标签列表
     */
    @Override
    public List<Tag> findAllTag() {
        return tagMapper.findAllTag();
    }

    /**
     * 查找标签及该标签下的博客数量
     * @return 标签及该标签下的博客数量
     */
    @Override
    public List<TagAndNums> findTagAndNums() {
//        List<TagAndNums> tagAndNumsList = (List<TagAndNums>) redisTemplate.boundValueOps("tagAndNums").get();
//        if (tagAndNumsList!=null){
//            System.out.println("从缓存获取tagAndNums");
//            return tagAndNumsList;
//        }
        List<Tag> allTag = tagMapper.findAllTag();
        List<TagAndNums> tagAndNumsList =new ArrayList<>();
        for (Tag tag:allTag) {
            int blogNum = blogTagMapper.countBlogByTagId(tag.getId());
            TagAndNums tagAndNums = new TagAndNums(blogNum,tag.getName());
            tagAndNumsList.add(tagAndNums);
        }
//        List<TagAndNums> tagAndNumsList = tagMapper.findTagAndNums();
//        redisTemplate.boundValueOps("tagAndNums").set(tagAndNumsList);
        return tagAndNumsList;
    }

    /**
     * 分页查找标签
     * @param pageNum 页码
     * @return 当前页码下的标签列表
     */
    @Override
    public TagPage findTagPage(int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Tag> tags = tagMapper.findAllTag();
        int total = (int) new PageInfo<Tag>(tags).getTotal();
        TagPage tagPage = new TagPage(tags,total);
        return tagPage;
    }

    /**
     * 根据id删除标签
     * @param id 标签id
     */
    @Override
    public void deleteTag(int id) {
        tagMapper.deleteTag(id);
    }

    /**
     * 添加标签
     * @param tag 标签名称
     */
    @Override
    public void addTag(Map<String, Object> tag) {
        Tag tag1 = new Tag();
        tag1.setName(tag.get("name").toString());
        Object id = tag.get("id");
        if (id != null && !"".equals(id.toString())){
            tag1.setId((long) Integer.parseInt(id.toString()));
            tagMapper.updateTag(tag1);
        }else {
            tagMapper.addTag(tag1);
        }
    }

    /**
     * 根据id查询标签
     * @param id 标签id
     * @return 标签内容
     */
    @Override
    public Tag findTagById(int id) {
        return tagMapper.findTagById(id);
    }


}
