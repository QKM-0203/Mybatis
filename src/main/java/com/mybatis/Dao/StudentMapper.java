package com.mybatis.Dao;

import com.mybatis.Bean.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select *  from student")
    List<Student> getStudentList();


    List<Student> getStudentAndTeacher();


    List<Student> getStudentAndTeacher1();


}
