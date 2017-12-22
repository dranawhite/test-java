package com.dranawhite.common.commons;


import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Test;

/**
 * Apache Commons Lang包ToStringBuilder、HashCodeBuilder、EqualsBuilder、CompareToBuilder的应用
 *
 * @author dranawhite 2017/12/21
 * @version 1.0
 */
public class UserPOTest {

    private UserPO user = new UserPO();

    /**
     * 输出结果：
     * com.forum.user.domain.UserPO@1963006a[userId=0,userName=<null>,credits=0,password=<null>,lastVisit=<null>,lastIp=<null>]
     */
    @Test
    public void testToString_style_default() {
        String userStr = ToStringBuilder.reflectionToString(user, ToStringStyle.DEFAULT_STYLE);
        System.out.println(userStr);
    }

    @Test
    public void testToString_style_prefix() {
        String userStr = ToStringBuilder.reflectionToString(user, ToStringStyle.SHORT_PREFIX_STYLE);
        final String excepted = "UserPO[userId=0,userName=<null>,credits=0,password=<null>,"
                + "lastVisit=<null>,lastIp=<null>]";
        Assert.assertEquals(excepted, userStr);
    }

    @Test
    public void testToString_style_extends() {
        UserPO userPO = new UserPO();
        userPO.setUserId(1);
        userPO.setUserName("tom");
        userPO.setPassword("123456");
        userPO.setDesc("description");
        userPO.setId(1001);

        String result = ToStringBuilder.reflectionToString(userPO, ToStringStyle
                .SHORT_PREFIX_STYLE);
        final String excepted = "UserPO[userId=1,userName=tom,credits=0,password=123456,"
                + "lastVisit=<null>,lastIp=<null>,id=1001,desc=description]";
        Assert.assertEquals(excepted, result);
    }

    @Test
    public void testToString_append() {
        String userStr = new ToStringBuilder(user, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("userId", 1).append("userName", "tom")
                .append("password", "123456").toString();
        final String excepted = "UserPO[userId=1,userName=tom,password=123456]";
        Assert.assertEquals(excepted, userStr);
    }

    @Test
    public void testHashCode() {
        int hash = HashCodeBuilder.reflectionHashCode(user);
        final int excepted = 667675993;
        Assert.assertEquals(excepted, hash);
    }

    @Test
    public void testHashCode_append() {
        int hash = new HashCodeBuilder().append(user.getUserId()).append(user.getUserName()).append
                (user.getPassword()).toHashCode();
        final int excepted = 861101;
        Assert.assertEquals(excepted, hash);
    }

    @Test
    public void testEquals() {
        UserPO user1 = new UserPO();
        user1.setUserId(1);
        user1.setUserName("tom");
        user1.setPassword("123456");

        UserPO user2 = new UserPO();
        user2.setUserId(1);
        user2.setUserName("tom");
        user2.setPassword("123456");

        boolean result = EqualsBuilder.reflectionEquals(user1, user2);
        Assert.assertTrue(result);
    }

    @Test
    public void testEquals_append() {
        UserPO user1 = new UserPO();
        user1.setUserId(1);
        user1.setUserName("tom");
        user1.setPassword("12356");

        UserPO user2 = new UserPO();
        user2.setUserId(1);
        user2.setUserName("tom");
        user2.setPassword("123456");

        boolean result = new EqualsBuilder().append(user1.getUserId(), user2.getUserId())
                .append(user1.getUserName(), user2.getUserName()).isEquals();
        Assert.assertTrue(result);
    }

    @Test
    public void testCompareTo() {
        UserPO user1 = new UserPO();
        user1.setUserId(1);
        user1.setUserName("tom");
        user1.setPassword("123456");

        UserPO user2 = new UserPO();
        user2.setUserId(1);
        user2.setUserName("tom");
        user2.setPassword("123456");

        boolean result = CompareToBuilder.reflectionCompare(user1, user2) == 0;
        Assert.assertTrue(result);
    }

    @Test
    public void testCompareTo_append() {
        UserPO user1 = new UserPO();
        user1.setUserId(1);
        user1.setUserName("tom");
        user1.setPassword("12356");

        UserPO user2 = new UserPO();
        user2.setUserId(1);
        user2.setUserName("tom");
        user2.setPassword("123456");

        boolean result = new CompareToBuilder().append(user1.getUserId(), user2.getUserId())
                .append(user1.getUserName(), user2.getUserName()).toComparison() == 0;
        Assert.assertTrue(result);
    }

}
