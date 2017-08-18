package com.dranawhite.pattern.command;

/**
 * 执行者
 * <pre>
 *     要求该命令执行这个请求
 * </pre>
 *
 * @author dranawhite 2017/8/18
 * @version 1.0
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

}
