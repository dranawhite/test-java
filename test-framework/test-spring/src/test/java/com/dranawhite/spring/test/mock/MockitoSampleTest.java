package com.dranawhite.spring.test.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

public class MockitoSampleTest {

    /**
     * 对接口进行模拟
     */
    UserService userService = Mockito.mock(UserService.class);

    /**
     * 对类进行模拟
     */
    UserServiceImpl userServiceImpl = Mockito.mock(UserServiceImpl.class);

    /**
     * 基于注解模拟类
     */
    @Mock
    private User user;

    @Before
    public void init() {
        // 初始化当前测试类所有@Mock注解模拟对象
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockInterface() {
        Mockito.when(user.getUserId()).thenReturn(1001);
        Mockito.when(user.getPassword()).thenReturn("admin");

        Assert.assertEquals(user.getUserId(), 1001);
        Assert.assertEquals(user.getPassword(), "admin");
    }
}
