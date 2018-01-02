package com.dranawhite.pattern.chain;

/**
 * 处理请求的接口
 *
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public interface Handler {

    void setSuccessor(Handler handler);

    void processRequest(Request request);

}
