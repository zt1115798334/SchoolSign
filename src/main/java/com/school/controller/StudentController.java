package com.school.controller;

import com.school.model.Student;
import com.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 跳转到编辑页面 -- 该页面可以 实现 保存 和修改
     * @return
     */
    @GetMapping("edit")
    public String toEditPage() {
        return "student/edit";
    }

    /**
     * 根据id获取学生信息跳转到编辑页面并且实现数据的赋值
     * @param id
     * @param model
     * @return
     */
    @GetMapping("get/{id}")
    public String toEditPage(@PathVariable Long id, Model model) {
        System.out.println("StudentController.toEditPage");
        Optional<Student> studentOpt = studentService.findStudent(id);
        studentOpt.ifPresent(student -> {
            model.addAttribute("student", student);
        });
        return "student/edit";
    }

    /**
     * 查询学生集合 跳转到学生列表页面
     * @param model
     * @return
     */
    @GetMapping(value = "list")
    public String studentList(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students", studentList);

        return "student/list";
    }

    /**
     * 保存学生信息 并且重定向列表页面
     * @param student
     * @param model
     * @return
     */
    @PostMapping("save")
    public String saveStudent(Student student, Model model) {
        Optional<Student> studentOptional = studentService.findStudent(student.getStudentId(), student.getStudentName());
        if (studentOptional.isPresent()) {
            model.addAttribute("message", "该学生信息重复，请重新添加");
            return "student/edit";
        }
        studentService.save(student);
        return "redirect:/student/list";
    }
    /**
     * 修改学生信息 并且重定向列表页面
     * @param student
     * @param model
     * @return
     */
    @PutMapping(value = "save")
    public String updateStudent(Student student) {
        studentService.update(student);
        return "redirect:/student/list";
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/student/list";
    }


}
