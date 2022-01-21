package com.clone.instagram.controller;

import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.FollowDto;
import com.clone.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/unfollow")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unfollow(@RequestParam(value = "fromUserId") int fromUserId,
                         @RequestParam(value = "toUserId") int toUserId){

        int result = userService.unfollow(fromUserId, toUserId);

    }

    @PostMapping("/follow")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void follow(@RequestBody FollowDto followDto){

        int result = userService.follow(followDto.getFromUserId(), followDto.getToUserId());
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(User user){

        int result = userService.save(user);
    }

    @GetMapping("/{userId}/followingList")
    public ResponseEntity<?> getFollowingList(int userId){

        List<User> followingList = userService.getFollowingList(userId);
        return ResponseEntity.ok(followingList);
    }

    @GetMapping("/{userId}/followerList")
    public ResponseEntity<?> getFollowerList(int userId){

        List<User> followerList = userService.getFollowerList(userId);
        return ResponseEntity.ok(followerList);
    }
}
