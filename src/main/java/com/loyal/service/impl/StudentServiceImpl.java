/**
 * FileName: StudentServiceImpl
 * Author:   Dragon
 * Date:     2019/5/20 11:25
 * History:
 */
package com.loyal.service.impl;

import com.loyal.entity.Student;
import com.loyal.mapper.StudentMapper;
import com.loyal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> findAllStudents() {

        return studentMapper.findAllStudents();
    }

    @Override
    public void saveStudent(Student student) {
        studentMapper.saveStudent(student);
    }

    @Override
    public void delStudent(int id) {
        studentMapper.delStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    /*@Override
    public List countById() {
        return studentDao.countById();
    }
*/
    @Override
    public List<Student> maxCountById() {

        return studentMapper.maxCountById();
    }

    @Override
    public List<Student> findTopSubjects() {

        return studentMapper.findTopSubjects();
    }

    @Override
    public List<Student> findAllByPro() {

        return studentMapper.findAllByPro();
    }
}
