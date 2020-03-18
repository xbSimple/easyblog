package com.xb.entity.result;

import java.io.Serializable;

public class TagAndNums implements Serializable {

    private Integer nums;

    private String tagName;

    public TagAndNums() {
    }

    public TagAndNums(Integer nums, String tagName) {
        this.nums = nums;
        this.tagName = tagName;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
