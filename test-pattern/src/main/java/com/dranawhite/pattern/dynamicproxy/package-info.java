/**
 * 动态代理
 * <pre>
 *     现在想为RealSubject这个类创建一个动态代理对象，JDK主要会做以下工作：
 *      1）获取RealSubject上的所有接口列表；
 *      2）确定要生成的代理类的类名，默认为：com.sun.proxy.$ProxyXXXX；
 *      3）根据需要实现的接口信息，在代码中动态创建该Proxy类的字节码；
 *      4）将对应的字节码转换为对应的class对象；
 *      5）创建InvocationHandler实例handler，用来处理Proxy所有方法调用；
 *      6）Proxy的class对象以创建的handler对象为参数，实例化一个proxy对象；
 * </pre>
 *
 * @author dranawhite 2017/8/9
 * @version 1.0
 */

package com.dranawhite.pattern.dynamicproxy;