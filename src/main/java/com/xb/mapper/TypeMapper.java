package com.xb.mapper;

import com.xb.entity.Type;
import com.xb.entity.result.TypeAndNums;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TypeMapper extends Mapper<Type> {

    /**
     * 查找分类及该分类下的博客数量
     * @return 分类及该分类下的博客数量
     */
    @Select("SELECT count(*) AS nums,t.name AS typeName FROM t_blog b LEFT JOIN t_type t ON b.typeId=t.id GROUP BY typeId")
    List<TypeAndNums> findTypeAndNums();

    /**
     * 查找所有的分类
     * @return 分类列表
     */
    @Select("SELECT * FROM t_type")
    List<Type> findAllType();

    /**
     * 根据id删除分类
     * @param id 分类id
     */
    @Delete("DELETE FROM t_type WHERE id = #{id}")
    void deleteType(int id);

    /**
     * 根据id更新分类
     * @param type 更新分类内容
     */
    @Update("UPDATE t_type SET name = #{name} WHERE id = #{id}")
    void updateType(Type type);

    /**
     * 添加分类
     * @param type 添加分类内容
     */
    @Insert("INSERT INTO t_type (name) values (#{name})")
    void addType(Type type);

    /**
     * 根据分类id查找分类
     * @param id 分类id
     * @return 分类内容
     */
    @Select("SELECT * FROM t_type WHERE id=#{id}")
    Type findTypeById(int id);
}
