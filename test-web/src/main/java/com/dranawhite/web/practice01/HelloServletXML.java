package com.dranawhite.web.practice01;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基于XML配置的Servlet
 *
 * @author dranawhite 2017/7/7
 * @version 1.0
 */
public class HelloServletXML extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curTime = dateFormat.format(new Date());
        request.setAttribute("currentTime", curTime);
        request.setAttribute("creator", "XML");
        request.getRequestDispatcher("/WEB-INF/view/practice01/hello.jsp").forward(request,
                response);
    }
}
