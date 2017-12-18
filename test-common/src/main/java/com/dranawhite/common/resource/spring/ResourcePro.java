package com.dranawhite.common.resource.spring;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * <pre>
 *  详解：
 *      WritableResource            可写资源接口
 *      ByteArrayResource           二进制数组表示的资源
 *      ClassPathResource           类路径下的资源
 *      FileSystemResource          文件系统资源，如D:/conf/bean.xml等
 *      InputStreamResource         以输入流返回表示的资源
 *      ServletContextResource      Web容器上下文中的资源
 *      UrlResource                 URL表示的资源
 *      PathResource                可以访问URL、Path、系统文件表示的资源，如HTTP资源，FTP资源等
 *
 *  图片：/docs/resource/Spring Resource类图.bmp
 *
 * </pre>
 *
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
public class ResourcePro {

    /**
     * 测试Spring加载文件系统下的资源文件
     *
     * @param path
     * @throws IOException
     */
    public void getResourceAtFile(String path) throws IOException {
        Resource res = new PathResource(path);
        InputStream ins = res.getInputStream();

        byte[] buffer = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (ins.read(buffer) != -1) {
            sb.append(new String(buffer));
        }
        System.out.println(sb.toString());
    }

    /**
     * Spring加载Classpath下的资源文件
     *
     * @param path
     * @throws IOException
     */
    public void getResourceAtClasspath(String path) throws IOException {
        Resource res = new ClassPathResource(path);
        InputStream ins = res.getInputStream();

        byte[] buffer = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (ins.read(buffer) != -1) {
            sb.append(new String(buffer));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ResourcePro pro = new ResourcePro();
        try {
            pro.getResourceAtFile("E://test.txt");
            pro.getResourceAtClasspath("test.txt");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
