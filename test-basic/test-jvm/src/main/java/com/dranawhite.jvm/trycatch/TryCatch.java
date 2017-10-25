package com.dranawhite.jvm.trycatch;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * JDK1.7 的try() catch语法糖
 * <pre>
 *     try()中的内容必须实现AuthClosabled接口
 * </pre>
 *
 * @author dranawhite 2017/10/25
 * @version 1.0
 */
public class TryCatch {
    public static void main(String[] args) {
        //1.创建当前字符缓冲输入流对象
        //JDK1.7以后直接释放资源
        //参数是一个字节输入流的对象
        try (BufferedInputStream bis =
                new BufferedInputStream(
                        new FileInputStream("src/com/qianfeng/Day/Demo.java"))) {
            //2.属于那个类型的流数组是填充 不是  覆盖 实际读取长度来获取真正 的数据
            //添加标记 -->印戳 在此输入流添加当前标记添加一个位置(当前在哪个位置重新开始读取)
            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
