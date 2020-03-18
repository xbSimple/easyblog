package com.xb.mapper;

import com.xb.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

    /**
     * 根据用户名密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Select("SELECT * FROM t_user WHERE username=#{username} AND password=#{password}")
    User checkUser(@Param("username") String username,@Param("password") String password);
}
