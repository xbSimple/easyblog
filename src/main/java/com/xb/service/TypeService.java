package com.xb.service;

import com.xb.entity.Type;
import com.xb.entity.result.TypeAndNums;
import com.xb.entity.result.TypePage;

import java.util.List;
import java.util.Map;

public interface TypeService {
    List<TypeAndNums> findTypeAndNums();

    List<Type> findAllType();

    TypePage findTypePage(int pageNum);

    void deleteType(int id);

    void addType(Map<String, Object> type);

    Type findTypeById(int id);
}
