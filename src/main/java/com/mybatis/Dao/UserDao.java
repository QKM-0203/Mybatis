package com.mybatis.Dao;

import com.mybatis.Bean.User;

import java.util.List;
import java.util.Map;


public interface UserDao {
         List<User> getUserList();

         List<User> getUserListLike(String value);

         List<User> limitUser(Map<String,Integer> map);

         User getUserById(int id);

         User getUserByName(String name);

         void insertUser(User user);

         void insertUserMap(Map<String ,Object> map);

         void updateUser(User user);

         void deleteUser(int id);


}
