package com.clone.instagram.unit.dao;

import com.clone.instagram.dao.UserDao;
import com.clone.instagram.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void getUserTest(){
        List<User> userList = userDao.selectUserList();

        //assert userList.size() != 0;
    }


}
