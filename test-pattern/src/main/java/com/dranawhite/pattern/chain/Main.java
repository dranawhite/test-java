package com.dranawhite.pattern.chain;

/**
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public class Main {

    public void main() {
        Request request = new Request();
        request.setAuthority(14);
        Handler handler = new Manager();
        handler.setSuccessor(new Director());
        handler.processRequest(request);
    }

}
