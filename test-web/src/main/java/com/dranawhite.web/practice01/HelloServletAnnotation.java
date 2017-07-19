package com.dranawhite.web.practice01;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基于Servlet 3.0注解的的Servlet
 *
 * @author dranawhite
 * @version 1.0 2017/7/7
 */
@WebServlet(value = "/helloAnnotation", name = "HelloServletAnnotation")
public class HelloServletAnnotation extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curTime = dateFormat.format(new Date());
        request.setAttribute("currentTime", curTime);
        request.setAttribute("creator", "Annotation");
        request.getRequestDispatcher("/WEB-INF/view/practice01/hello.jsp").forward(request,
                response);
    }

}
