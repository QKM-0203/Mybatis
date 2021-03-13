package com.mybatis.Dao;

import com.mybatis.Bean.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    @Insert("insert into blog values(#{id},#{title},#{author},#{createTime},#{views})")
    void addBlog(Blog blog);

    List<Blog> queryBlog(Map<String,Object> map);

    void updateBlog(Map<String,Object> map);

    List<Blog> queryBlogByListId(Map<String,Object> map);

}
