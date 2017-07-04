package com.dranawhite.web.annotation;

import org.junit.Test;

/**
 * @author dranawhite.web.jvm.jvm 2017/7/4
 * @version 1.0
 */
public class AnnotationTest {

    @Test
    public void testPostConstructor() {
        UserService userService = new UserService();
        userService = null;
    }

}
