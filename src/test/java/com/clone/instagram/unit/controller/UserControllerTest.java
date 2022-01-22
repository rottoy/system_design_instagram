package com.clone.instagram.unit.controller;


import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.FollowDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void followTest() throws Exception{

        FollowDto followDto = FollowDto.builder()
                .fromUserId(1)
                .toUserId(4)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/user/follow")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(followDto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"success\":false,\"message\":\"userId 1 already follow userId 4\"}"));

    }

    @Test
    public void unfollowTest() throws Exception{
        FollowDto followDto = FollowDto.builder()
                .fromUserId(1)
                .toUserId(4)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/user/unfollow")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(followDto)))
               .andExpect(status().isOk())
               .andExpect(content().json("{\"success\":true,\"message\":\"userId 1 unfollowed userId 4\"}"));
    }

    @Test
    public void saveTest() throws Exception{
        User user = User.builder()
                .userName("teemo")
                .email("rottoy@gmail.com")
                .dateOfBirth(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2013-04-08 10:10:10"))
                .password("1234")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("user saved")));
    }
}
