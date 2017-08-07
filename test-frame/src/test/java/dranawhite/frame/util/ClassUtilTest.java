package dranawhite.frame.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public class ClassUtilTest {

    @Test
    public void getClassSetTest() {
        Set<Class<?>> clsSet = ClassUtil.getClassSet("dranawhite.frame.util");
        Assert.assertEquals(clsSet.size(), 10);
    }

}
