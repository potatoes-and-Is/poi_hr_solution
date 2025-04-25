package com.poi.hr.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

//    @GetMapping("/poihr")
//    public ModelAndView admin(ModelAndView modelAndView) {
//        modelAndView.setViewName("/admin/admin");
//        return modelAndView;
//    }
//
//    @GetMapping("/user/page")
//    public ModelAndView user(ModelAndView modelAndView) {
//        modelAndView.setViewName("user/user");
//        return modelAndView;
//    }
}
