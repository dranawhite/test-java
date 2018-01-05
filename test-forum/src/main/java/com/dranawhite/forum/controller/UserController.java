package com.dranawhite.forum.controller;

import com.dranawhite.forum.domain.UserPO;
import com.dranawhite.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dranawhite 2018/1/5
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getInfo")
    public ModelAndView getUserInfo(@RequestBody UserPO user) {
        UserPO result = userService.getUserInfo(user.getUserId());
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", result);
        mv.setViewName("user");
        return mv;
    }

}
