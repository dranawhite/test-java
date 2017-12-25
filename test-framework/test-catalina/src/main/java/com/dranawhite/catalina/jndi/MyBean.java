package com.dranawhite.catalina.jndi;

/**
 * @author liangyq 2017/12/25
 */
public class MyBean {

    private String foo = "Default Foo";

    private int bar = 0;

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
