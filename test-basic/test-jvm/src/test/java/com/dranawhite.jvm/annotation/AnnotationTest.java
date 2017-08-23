package com.dranawhite.jvm.annotation;

import org.junit.Test;

/**
 * @author dranawhite.web.jvm.jvm 2017/7/4
 * @version 1.0
 */
class AnnotationTest {

    @Test
    @UserCase(id = 1)
    public void testUser() {
        System.out.println("测试注解：");
        UserCaseTracker userCaseTracker = new UserCaseTracker();
        userCaseTracker.annotation(AnnotationTest.class);
    }

}
