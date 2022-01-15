package com.clone.instagram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "";
    }
}
