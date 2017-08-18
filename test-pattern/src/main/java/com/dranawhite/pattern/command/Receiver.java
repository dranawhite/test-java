package com.dranawhite.pattern.command;

/**
 * 接收者
 * <pre>
 *     知道如何实施与执行一个与请求相关的操作，任何类都可能作为一个接收者
 * </pre>
 *
 * @author dranawhite 2017/8/18
 * @version 1.0
 */
public class Receiver {

    public void action() {
        System.out.println("执行请求！");
    }

}
