package com.clone.instagram.unit.service;

import com.clone.instagram.dao.UserDao;
import com.clone.instagram.model.User;
import com.clone.instagram.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Test
    public void saveUser() throws ParseException{
        String userName = "rottoy";
        String email = "rottoy@gmail.com";
        String password = "1234";
        Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2013-04-08 10:10:10");
        User user = User.builder()
                .userName(userName)
                .email(email)
                .password(password)
                .dateOfBirth(dateOfBirth)
                .build();

        userService.save(user);
    }

    @Test
    public void getFollowingTest(){
        int userId = 1;
        List<User> userList = userService.getFollowingList(userId, PageRequest.of(0, 10));

        assert userList.size() == 3;
    }

    @Test
    public void getFollowerTest(){
        int userId = 1;
        List<User> userList = userService.getFollowerList(userId, PageRequest.of(0, 10));

        assert userList.size() == 2;
    }

    @Test
    public void followTest(){
        int fromUserId = 2;
        int toUserId = 5;

        int followCount = userService.follow(fromUserId, toUserId);

        assert followCount == 1;
    }

    @Test
    public void unfollowTest(){
        int fromUserId = 1;
        int toUserId = 3;

        int unfollowCount = userService.unfollow(fromUserId, toUserId);

        assert unfollowCount == 1;

        int unfollowCount2 = userService.unfollow(fromUserId, toUserId);

        assert unfollowCount2 == 0;
    }
}
