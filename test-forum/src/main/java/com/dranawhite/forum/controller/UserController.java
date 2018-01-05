package com.dranawhite.forum.controller;

import com.dranawhite.forum.domain.UserPO;
import com.dranawhite.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dranawhite 2018/1/5
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/user",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getInfo")
    @ResponseBody
    public UserPO getUserInfo(@RequestBody UserPO user) {
        return userService.getUserInfo(user.getUserId());
    }

}
