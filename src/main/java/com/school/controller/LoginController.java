package com.school.controller;

import com.school.model.Teacher;
import com.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {


    private final TeacherService teacherService;

    @Autowired
    public LoginController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping({"/", "login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("login")
    public String login(@RequestParam String account, @RequestParam String password,
                        Model model,
                        HttpSession session) {
        Optional<Teacher> teacher = teacherService.findTeacher(account, password);
        if (teacher.isPresent()) {
            session.setAttribute("loginUser", teacher.get());
            return "redirect:/student/list";
        } else {
            model.addAttribute("message", "登录失败");
            return "login";
        }
    }
}
