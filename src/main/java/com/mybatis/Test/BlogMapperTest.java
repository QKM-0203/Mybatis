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

    @Test
    public void queryBlogTest(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap<String, Object> map = new HashMap<>();
            //map.put("title","Java");
           map.put("author","狂神说");
            //map.put("views",9999);
            List<Blog> blogs = mapper.queryBlog(map);
            blogs.forEach((blog)-> System.out.println(blog.toString()));
            sqlSession.close();
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
