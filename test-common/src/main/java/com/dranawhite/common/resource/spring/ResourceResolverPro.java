package com.dranawhite.common.resource.spring;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;

/**
 * 支持Ant路径风格的资源访问
 * <pre>
 *      Ant风格路径：
 * ?    表示单个字符
 * *    表示任意字符
 * **   表示多层路径
 *
 * 图片：/docs/resource/Spring资源加载器类图.png
 * 详解：
 *      ResourceLoader              不支持ANT风格的路径
 *      ResourcePatternResolver     开始支持ANT风格的路径
 * </pre>
 *
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
public class ResourceResolverPro {

    public void getResourceAtAntPath(String path) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource[] resArr = resolver.getResources(path);
        for (Resource res : resArr) {
            InputStream ins = res.getInputStream();

            byte[] buffer = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while (ins.read(buffer) != -1) {
                sb.append(new String(buffer));
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        ResourceResolverPro pro = new ResourceResolverPro();
        pro.getResourceAtAntPath("classpath:/**/*.txt");
    }

}
