package com.school.controller;

import com.school.model.SignRecord;
import com.school.service.SignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("signRecord")
public class SignRecordController {


    private final SignRecordService signRecordService;


    @Autowired
    public SignRecordController(SignRecordService signRecordService) {
        this.signRecordService = signRecordService;
    }

    /**
     * 获取学生签到信息并且跳转到签到记录列表页面
     * @param studentId
     * @param model
     * @return
     */
    @GetMapping(value = "get/{studentId}")
    public String getSignRecord(@PathVariable("studentId") Long studentId, Model model) {
        List<SignRecord> studentSignRecord = signRecordService.findStudentSignRecord(studentId);
        model.addAttribute("signRecord", studentSignRecord);
        return "signRecord/list";
    }

    /**
     * 跳转到签到界面
     * @param model
     * @return
     */
    @GetMapping(value = "page")
    public String signRecordPage(Model model) {
        boolean code = model.containsAttribute("code");
        System.out.println("code = " + code);
        return "signRecord/sr";
    }

    /**
     * 提交签到信息 并且跳转到签到界面显示签到成功信息
     * @param studentId
     * @param studentName
     * @param request
     * @param model
     * @return
     */
    @PostMapping(value = "save")
    public ModelAndView signRecord(@RequestParam String studentId, @RequestParam String studentName, HttpServletRequest request, Model model) {
        String ip = getIP(request);
        signRecordService.singRecord(studentId, studentName, ip);
        ModelAndView mv = new ModelAndView();
        mv.addObject("code", "0");
        mv.setViewName("signRecord/sr");
        return mv;
    }


    private static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
