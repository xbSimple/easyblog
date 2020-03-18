package com.xb.service;

import com.xb.entity.Tag;
import com.xb.entity.Type;
import com.xb.entity.result.TagAndNums;
import com.xb.entity.result.TagPage;

import java.util.List;
import java.util.Map;

public interface TagService {
    List<TagAndNums> findTagAndNums();

    List<Tag> findAllTag();

    TagPage findTagPage(int pageNum);

    void deleteTag(int id);

    void addTag(Map<String, Object> tag);

    Tag findTagById(int id);
}
