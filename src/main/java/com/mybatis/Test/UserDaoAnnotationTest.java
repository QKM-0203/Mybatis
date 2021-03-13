package com.mybatis.Test;

import com.mybatis.Bean.User;
import com.mybatis.Dao.UserDaoAnnotation;
import com.mybatis.Utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoAnnotationTest {



    @Test
    public void getUserListTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDaoAnnotation mapper = sqlSession.getMapper(UserDaoAnnotation.class);
        List<User> userList = mapper.getUserList();
        userList.forEach((user)-> System.out.println(user.toString()));
        sqlSession.close();
    }


    @Test
    public void insertUserListTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDaoAnnotation mapper = sqlSession.getMapper(UserDaoAnnotation.class);
         mapper.insertUser(new User(19,"王苗"));

         //如果在获取sqlSession的时候设置了true就不用在手动提交了，但是怕代码有问题，一般不设置
         sqlSession.commit();
        sqlSession.close();
    }



}
