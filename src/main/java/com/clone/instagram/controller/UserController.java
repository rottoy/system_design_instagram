package com.clone.instagram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    //parameter : userid,
    @PostMapping("/unfollow")
    public String unfollow(){
        return "";
    }

    @PostMapping("/follow")
    public String follow(){
        return "";
    }

    @PostMapping("/save")
    public String save(){
        return "";
    }

    @GetMapping("/{userId}")
    public String getUserAndPosts(){
        return "";
    }
}
