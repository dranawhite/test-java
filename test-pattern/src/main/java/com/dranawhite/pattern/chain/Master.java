package com.dranawhite.pattern.chain;

/**
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public class Master implements Handler {

    @Override
    public void setSuccessor(Handler handler) {
        // 链接链的最后一环
    }

    @Override
    public void processRequest(Request request) {
        // Do Something
    }
}
