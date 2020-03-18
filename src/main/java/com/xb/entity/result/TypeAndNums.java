package com.xb.entity.result;

import java.io.Serializable;

public class TypeAndNums implements Serializable {

    private Integer nums;

    private String typeName;

    public TypeAndNums() {
    }

    public TypeAndNums(Integer nums, String typeName) {
        this.nums = nums;
        this.typeName = typeName;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
