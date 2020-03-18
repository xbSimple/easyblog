package com.xb.entity.result;

import com.xb.entity.Tag;

import java.io.Serializable;
import java.util.List;

public class TagPage implements Serializable {
    private List<Tag> tags;

    private Integer total;

    public TagPage() {
    }

    public TagPage(List<Tag> tags, Integer total) {
        this.tags = tags;
        this.total = total;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
