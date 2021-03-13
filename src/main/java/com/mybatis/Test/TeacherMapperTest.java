package com.mybatis.Test;

import com.mybatis.Bean.Student;
import com.mybatis.Bean.Teacher;
import com.mybatis.Dao.StudentMapper;
import com.mybatis.Dao.TeacherMapper;
import com.mybatis.Utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {
    @Test
    public void getStudentBytIDTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher studentBytID = mapper.getStudentBytID(1);
        System.out.println(studentBytID);
        sqlSession.close();
    }

}
