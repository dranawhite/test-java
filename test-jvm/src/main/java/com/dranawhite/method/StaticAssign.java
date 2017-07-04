package com.dranawhite.method;

/**
 * 方法调用——解析
 * <p>在静态分派时，参数自动进行类型提升，顺序如下: char > int > long > float > double</p>
 * <p>然后进行自动装箱，以及对父类和接口的匹配动作</p>
 *
 * @author dranawhite 2017/7/4
 * @version 1.0
 */
public class StaticAssign {

    /**
     * @param subClass 子类
     */
    public void parse(SubClass subClass) {
        System.out.println("SubClass invoke!");
    }

    /**
     * @param superClass 父类
     */
    public void parse(SuperClass superClass) {
        System.out.println("SuperClass invoke!");
    }

    /**
     * @param superInterface 接口
     */
    public void parse(SuperInterface superInterface) {
        System.out.println("SuperInterface invoke!");
    }

    /**
     * @param num 基本类型
     */
    public void parse(int num) {
        System.out.println("int invoke!");
    }

    /**
     * @param num 封装类型
     */
    public void parse(Integer num) {
        System.out.println("Integer invoke!");
    }

}
