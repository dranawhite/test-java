package com.dranawhite.method;

/**
 * @author dranawhite 2017/7/4
 * @version 1.0
 */
public class SubClass extends SuperClass implements SuperInterface {

    /**
     * 子类重写父类方法时，有关异常的处理：
     * <p>
     *     如果是RuntimeException，编译器不会做静态检查；如果是检查异常，则子类不能抛出比父类更广范围的异常；
     * </p>
     *
     * @param param 字符串参数
     * @param num   整型参数
     */
    @Override
    public void assignMethod(String param, int num) {
        throw new NullPointerException();
    }

}
