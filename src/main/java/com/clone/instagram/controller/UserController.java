package com.clone.instagram.controller;

import com.clone.instagram.exception.DuplicateUserNameException;
import com.clone.instagram.exception.UserAlreadyFollowException;
import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.FollowDto;
import com.clone.instagram.model.payload.ApiResponse;
import com.clone.instagram.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.scanners.ApiDescriptionReader;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/unfollow")
    public ResponseEntity<?> unfollow(@RequestBody FollowDto followDto){

        String message;
        boolean isSuccess = false;
        try {
            userService.unfollow(followDto.getFromUserId(), followDto.getToUserId());
            message = String.format("userId %s unfollowed userId %s", followDto.getFromUserId(), followDto.getToUserId());
            isSuccess = true;
        } catch (UserAlreadyFollowException e) {
            message = String.format("userId %s doesn't follow userId %s", followDto.getFromUserId(), followDto.getToUserId());
        }
        log.info("POST /user/unfollow result: " + message);
        return ResponseEntity.ok(new ApiResponse(isSuccess, message));
    }

    @PostMapping("/follow")
    public ResponseEntity<?> follow(@RequestBody FollowDto followDto){

        String message;
        boolean isSuccess = false;
        try {
            userService.follow(followDto.getFromUserId(), followDto.getToUserId());
            message = String.format("userId %s followed userId %s", followDto.getFromUserId(), followDto.getToUserId());
            isSuccess = true;
        } catch (UserAlreadyFollowException e) {
            message = String.format("userId %s already follow userId %s", followDto.getFromUserId(), followDto.getToUserId());
        }
        log.info("POST /user/follow result: " + message);
        return ResponseEntity.ok(new ApiResponse(isSuccess, message));
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> save(User user){

        String message;
        boolean isSuccess = false;
        try {
            userService.save(user);
            message = String.format("user saved %s : ",user.toString());
            isSuccess = true;
        } catch (DuplicateUserNameException e) {
            message = String.format("userName '%s' already exists.", user.getUserName());
        }
        log.info("POST /user/save result: " + message);
        return ResponseEntity.ok(new ApiResponse(isSuccess, message));
    }

    @GetMapping("/{userId}/followingList")
    public ResponseEntity<?> getFollowingList(@PathVariable int userId){
        return ResponseEntity.ok(userService.getFollowingList(userId));
    }

    @GetMapping("/{userId}/followerList")
    public ResponseEntity<?> getFollowerList(@PathVariable int userId){
        return ResponseEntity.ok(userService.getFollowerList(userId));
    }
}
