package com.dranawhite.forum.controller;

import com.alibaba.fastjson.JSON;
import com.dranawhite.forum.domain.UserPO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author dranawhite 2018/1/5
 * @version 1.0
 */
public class UserControllerTest extends BaseControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getInfo() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/getInfo");
        requestBuilder.accept(MediaType.APPLICATION_JSON);
        requestBuilder.contentType(MediaType.APPLICATION_JSON);
        UserPO user = new UserPO();
        user.setUserId(1001);
        requestBuilder.content(JSON.toJSONString(user));
        ResultActions result = mockMvc.perform(requestBuilder);
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

}
