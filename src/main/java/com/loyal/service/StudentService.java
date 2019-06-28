package com.loyal.service;

import com.loyal.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();

   void saveStudent(Student student);

    void delStudent(int id);

     void updateStudent(Student student);

    /*List countById();
     */
    List<Student> maxCountById();

    List<Student> findTopSubjects();

    List<Student> findAllByPro();
}
