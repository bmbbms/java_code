package com.yangsheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/13 17:21
 **/
@WebServlet(name = "RediectServlet",urlPatterns = "/redirect")
public class RediectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("找redeicit2");
        response.sendRedirect("/redirect2");
    }
}
