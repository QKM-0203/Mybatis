package com.mybatis.Utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    //工厂对象只需要创建一次，并且一直存在，不要引起资源浪费，最好使用单例模式，想象成数据库连接池，从中取所以他得存在，并且只存在一个
    private  static SqlSessionFactory sqlSessionFactory = null;


    private MybatisUtils(){

    }

    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory == null){
            String resource = "mybatis.xml";
            try {
                //加载全局配置文件
                InputStream resourceAsStream = Resources.getResourceAsStream(resource);
                //SqlSessionFactoryBuilder尽量放成局部变量，因为只使用一次,还要解析xml文件（XMLConfigBuilder），获取配置文件的信息，
                // 然后获取sqlSessionFactory对象
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
                return sqlSessionFactory;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }




    //SqlSession对象类似于每个请求一个该对象，所以用完该对象一定记得关闭
    //设置为true自动提交，尽量不设置自动提交，怕代码有问题
    public static SqlSession getSqlSession(){
        if(sqlSessionFactory == null){
            getSqlSessionFactory();
        }
        return  sqlSessionFactory.openSession();
    }
}
