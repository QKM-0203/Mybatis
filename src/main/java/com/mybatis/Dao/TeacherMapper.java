package com.mybatis.Dao;

import com.mybatis.Bean.Student;
import com.mybatis.Bean.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    @Select("select *  from teacher")
    List<Student> getStudentList();

    Teacher getStudentBytID(@Param("tid") int id);


    Teacher getStudentBytID1();
}
