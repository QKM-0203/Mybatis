package com.mybatis.Test;

import com.mybatis.Bean.User;
import com.mybatis.Dao.UserDao;
import com.mybatis.Utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {



    //方法一
    @Test
    public  void getUserListTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList  = userDao.getUserList();
            userList.forEach((user)->System.out.println(user.toString()));
            sqlSession.close();


    }



    @Test
    public  void limitUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startAt",0);
        map.put("pageSize",3);
        List<User> userList  = userDao.limitUser(map);
        userList.forEach((user)->System.out.println(user.toString()));
        sqlSession.close();


    }



    @Test
    public void getUserListLikeTest(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();

            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserListLike("李");
            userList.forEach((user)->System.out.println(user.toString()));

            sqlSession.close();



    }


    //方法二，不常用
    @Test
    public void getUserListTest1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{

            List<User> userList = sqlSession.selectList("getUserList");
            userList.forEach((user)->System.out.println(user.toString()));
        }catch (Exception e){

        }finally {
            sqlSession.close();
        }


    }

    @Test
    public void getUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User userById = userDao.getUserById(12);
            System.out.println(userById.toString());
        }catch (Exception e){

        }finally {
            sqlSession.close();
        }
    }



    @Test
    public void getUserByNameTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User userByName = userDao.getUserByName("杨倩");
            System.out.println(userByName.toString());
        }catch (Exception e){

        }finally {
            sqlSession.close();
        }
    }




    @Test
    public void insertUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();


            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = new User(null, "杨倩");
            userDao.insertUser(user);
            System.out.println(user.getId());

            //事务提交
            sqlSession.commit();
            sqlSession.close();

    }


    @Test
    public void insertUserMapTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{

            UserDao userDao = sqlSession.getMapper(UserDao.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("ID",1);
            map.put("Name","王苗");
            userDao.insertUserMap(map);

        }catch (Exception e){

        }finally {
            //事务提交（增删改需要事务提交）
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{

            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.updateUser(new User(12,"戚凯萌qq"));

        }catch (Exception e){

        }finally {


            //事务提交
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{

            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.deleteUser(1);

        }catch (Exception e){

        }finally {
            //需要提交事务，不然不会有变化，会回滚
            sqlSession.commit();
            sqlSession.close();
        }
    }



}
