package com.poi.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/poihr"})
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "index";
    }

    @GetMapping("/attendanceList")
    public String attendanceList(Model model) {
        model.addAttribute("title", "Attendance List");
        return "attendance/attendanceList";
    }

}
