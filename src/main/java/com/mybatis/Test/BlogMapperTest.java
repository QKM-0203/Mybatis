package com.mybatis.Test;

import com.mybatis.Bean.Blog;
import com.mybatis.Dao.BlogMapper;
import com.mybatis.Utils.MybatisUtils;
import com.mybatis.Utils.UuidUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogMapperTest {

    @Test
    public void addBlogTest(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId(UuidUtils.getId());
            blog.setTitle("Mybatis");
            blog.setAuthor("狂神说");
            blog.setCreateTime(new Date());
            blog.setViews(9999);

            mapper.addBlog(blog);

            blog.setId(UuidUtils.getId());
            blog.setTitle("Java");
            mapper.addBlog(blog);

            blog.setId(UuidUtils.getId());
            blog.setTitle("Spring");
            mapper.addBlog(blog);

            blog.setId(UuidUtils.getId());
            blog.setTitle("微服务");
            mapper.addBlog(blog);

            sqlSession.commit();
            sqlSession.close();
    }

    /**
     * 缓存就是为了提高效率，如果是频繁更新的东西，就没有必要放到缓存里面，因为获取的时候会出问题，同时增删改查会刷新缓存的
     */
    @Test
    public void queryBlogTest(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap<String, Object> map = new HashMap<>();
            //map.put("title","Java");
             map.put("author","狂神说");
            //map.put("views",9999);
            List<Blog> blogs = mapper.queryBlog(map);
            //一级缓存默认开启，只在一次sqlSession开启到关闭这之间，查询会缓存到内存中，只会开启一次链接，若第二次执行相同操作
        //就直接从内存中取，不会建立第二次链接，但是若执行增删改，就会清空缓存，这是就会重新链接数据库，还有就是手动清理缓存
           // List<Blog> blogs1 = mapper.queryBlog(map);
            blogs.forEach((blog)-> System.out.println(blog.toString()));
            //blogs1.forEach((blog)-> System.out.println(blog.toString()));
            sqlSession.close();

            //二级缓存，就是全局的缓存，记得让类实现下序列化话接口,针对一个mapper文件缓存，当一个sqlSession关闭之后，就会从一级缓存的地方放到二级缓存，第二次若查找相同的就会从二级缓存
            //的地方再次找,不会在去链接数据库，开启二级缓存，在配置文件加和mapper文件加

//        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
//        BlogMapper mapper1 = sqlSession1.getMapper(BlogMapper.class);
//        HashMap<String, Object> map1 = new HashMap<>();
//        //map.put("title","Java");
//        map1.put("author","狂神说");
//        //map.put("views",9999);
//        List<Blog> blogs1 = mapper1.queryBlog(map1);
//        //一级缓存默认开启，只在一次sqlSession开启到关闭这之间，查询会缓存到内存中，只会开启一次链接，若第二次执行相同操作
//        //就直接从内存中取，不会建立第二次链接，但是若执行增删改，就会清空缓存，这是就会重新链接数据库，还有就是手动清理缓存
//        // List<Blog> blogs1 = mapper.queryBlog(map);
//        blogs1.forEach((blog)-> System.out.println(blog.toString()));
//        //blogs1.forEach((blog)-> System.out.println(blog.toString()));
//        sqlSession1.close();
    }

        @Test
        public void updateBlogTest(){
                SqlSession sqlSession = MybatisUtils.getSqlSession();
                BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
                HashMap<String, Object> map = new HashMap<>();
                 map.put("title","Java3");
                 map.put("author","狂神说2");
                map.put("id","2a327598c9374510aa929a18724d4b0a");
                 mapper.updateBlog(map);
                sqlSession.commit();
                sqlSession.close();


        }


        @Test
        public void queryBlogByIDListTest(){
                SqlSession sqlSession = MybatisUtils.getSqlSession();
                BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
                HashMap<String, Object> map = new HashMap<>();
                ArrayList<String> idList = new ArrayList<>();
//                idList.add("2a327598c9374510aa929a18724d4b0a");
//                idList.add("6adf02242f6f49d0bd3637a81506bc1a");
//                idList.add("952f3544cbb843c7a38041b3d837ae25");
                map.put("idList",idList);
                List<Blog> blogs = mapper.queryBlogByListId(map);
                blogs.forEach((blog)-> System.out.println(blog.toString()));
                sqlSession.close();
        }
}
