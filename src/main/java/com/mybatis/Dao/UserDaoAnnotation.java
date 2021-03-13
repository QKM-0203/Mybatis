package com.mybatis.Dao;

import com.mybatis.Bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDaoAnnotation {
    @Select("select * from mybatis_User")
    List<User> getUserList();

    @Insert("insert into mybatis_User values(#{id},#{name})")
    void insertUser(User user);


    User getUserById(@Param("id") int id);
}
