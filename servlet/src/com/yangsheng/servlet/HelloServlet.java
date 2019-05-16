package com.yangsheng.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/13 8:32
 **/


@WebServlet("/hello")
public class HelloServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String username = request.getParameter("username");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter os = response.getWriter();



        os.println("hello"+ username+"永生");

    }
}
