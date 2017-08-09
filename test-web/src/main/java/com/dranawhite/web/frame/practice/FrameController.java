package com.dranawhite.web.frame.practice;

import com.dranawhite.frame.annotation.Action;
import com.dranawhite.frame.annotation.Controller;
import com.dranawhite.frame.bean.Param;
import com.dranawhite.frame.bean.View;

/**
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
@Controller
public class FrameController {

    @Action(value = "get:/helloWorld")
    public View printHelloWorld(Param param) {
        return new View("practice01/hello.jsp");
    }
}
