/**
 * FileName: StudentAction
 * Author:   Dragon
 * Date:     2019/5/20 11:13
 * History:
 */
package com.loyal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loyal.entity.Student;
import com.loyal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAllStudents")
    public ModelAndView findAllStudents() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentList");
        mv.addObject("students", studentService.findAllStudents());
        return mv;
    }

    @RequestMapping("/saveStudentUI")
    public String saveStudentUI() {
        return "saveStudent";
    }

    @RequestMapping("/saveStudent")
    public String saveStudent(Student student) {
        studentService.saveStudent(student);
        return "forward:/findAllStudents";
    }

    @RequestMapping("/delStudent")
    public String delStudent(String id) {
        int sid = Integer.parseInt(id);
        studentService.delStudent(sid);
        return "forward:/findAllStudents";
    }

    @RequestMapping("/updateStudentUI")
    public String updateStudentUI(String id, HttpServletRequest request) {
        int sid = Integer.parseInt(id);
        request.setAttribute("id", id);
        return "updateStudent";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "forward:/findAllStudents";
    }

    /* public String countById() throws IOException {
         List conunt = studentService.countById();

         ServletActionContext.getResponse().getWriter().print(conunt.get(0));
         return null;
     }
 */
    @RequestMapping(value = "/maxCountById", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String maxCountById() throws JsonProcessingException {
        List<Student> students = studentService.maxCountById();
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(students);
        return s;
    }

    @RequestMapping(value = "/findTopSubjects", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String findTopSubjects() throws JsonProcessingException {
        List<Student> top = studentService.findTopSubjects();
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(top);
        return s;

    }

    @RequestMapping("/findAllByPro")
    public String findAllByPro() {
        List<Student> all = studentService.findAllByPro();
        return null;
    }
}
