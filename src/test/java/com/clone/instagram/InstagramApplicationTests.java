package com.clone.instagram;


import com.clone.instagram.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InstagramApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads(){
        System.out.println(userDao.selectUserList());

    }

}
