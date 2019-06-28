package com.loyal.mapper;

import com.loyal.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    @Select("select * from s_student")
    List<Student> findAllStudents();

    @Insert("insert into s_student(name,subject,score) values(#{name},#{subject},#{score})")
    void saveStudent(Student student);

    @Delete("delete from s_student where id=#{id}")
    void delStudent(int id);
@Update("update s_student set name=#{name},subject=#{subject},score=#{score} where id=#{id}")
    void updateStudent(Student student);

   /* List countById();
    */
   @Select("SELECT * FROM s_student WHERE score IN (SELECT MAX(score) FROM s_student GROUP BY `name`);")
   List<Student> maxCountById();

   @Select("SELECT * FROM s_student WHERE score IN (SELECT MAX(score) FROM s_student GROUP BY `subject`);")
    List<Student> findTopSubjects();

   @Select({"call pro1()"})
    List<Student> findAllByPro();
}
