package com.xb.entity.result;

import com.xb.entity.Type;

import java.io.Serializable;
import java.util.List;

public class TypePage implements Serializable {

    private List<Type> types;

    private Integer total;

    public TypePage() {
    }

    public TypePage(List<Type> types, Integer total) {
        this.types = types;
        this.total = total;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
