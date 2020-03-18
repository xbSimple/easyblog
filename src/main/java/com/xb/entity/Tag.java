package com.xb.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;

@Table(name = "t_tag")
public class Tag implements Serializable {

    @Column(name = "id",type = MySqlTypeConstant.BIGINT,isKey = true,isAutoIncrement = true)
    private Long id;

    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String  name;

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
