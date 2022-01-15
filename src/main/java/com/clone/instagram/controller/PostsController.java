package com.clone.instagram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostsController {

    @GetMapping("/save")
    public String save(){
        return "";
    }

    @GetMapping("/delete/{postsId}")
    public String delete(){
        return "";
    }

    @GetMapping("/timeline")
    public String getTimeline(){
        return "";
    }

    @GetMapping("/{postId}")
    public String getPosts(){
        return "";
    }

    @GetMapping("/{postId}/comments")
    public String getPostsAndComments(){
        return "";
    }

    @GetMapping("/likes/{postId}")
    public String getPostsLikeUsers(){
        return "";
    }

    @PostMapping("/likes/{postId}")
    public String likePosts(){
        return "";
    }
}
