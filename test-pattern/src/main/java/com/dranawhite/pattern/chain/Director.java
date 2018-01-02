package com.dranawhite.pattern.chain;

/**
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public class Director implements Handler {

    private Handler handler;

    @Override
    public void setSuccessor(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void processRequest(Request request) {
        if (request.getAuthority() < 10) {
            // Do Something
        } else if (handler != null) {
            handler.processRequest(request);
        }
    }
}
