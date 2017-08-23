package com.dranawhite.pattern.command;

/**
 * @author dranawhite 2017/8/18
 * @version 1.0
 */
class Main {

    public void main() {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.executeCommand();
    }

}
