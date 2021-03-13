package com.mybatis.Test;

import com.mybatis.Bean.Student;
import com.mybatis.Dao.StudentMapper;
import com.mybatis.Utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {


    @Test
    public void getStudentListTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudentList();

        studentList.forEach((student) -> System.out.println(student));

        sqlSession.close();
    }


    //方法一 多对1
    @Test
    public void getStudentAndStudentTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudentAndTeacher();

        studentList.forEach((student) -> System.out.println(student));

        sqlSession.close();
    }



    //方法2 多对1
    @Test
    public void getStudentAndStudentTest1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudentAndTeacher1();

        studentList.forEach((student) -> System.out.println(student));

        sqlSession.close();
    }


}
