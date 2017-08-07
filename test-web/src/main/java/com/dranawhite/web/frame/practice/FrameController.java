package com.dranawhite.web.frame.practice;

import dranawhite.frame.annotation.Action;
import dranawhite.frame.annotation.Controller;
import dranawhite.frame.bean.View;

/**
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
@Controller
public class FrameController {

    @Action(value = "post:/helloWorld")
    public View printHelloWorld() {
        return new View("practice01/hello.jsp");
    }
}
