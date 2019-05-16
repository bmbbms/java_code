package com.yangsheng.servlet;

import com.yangsheng.bean.User;
import com.yangsheng.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/13 9:28
 **/
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("count",0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置返回编码
        response.setContentType("text/html;charset=utf-8");

        // 2. 获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("hh1");
        // 3. 对用户名和密码进行判断

        try {
            UserService us = new UserService();
            User user = us.login(username, password);
                  if (user == null){
            System.out.println("用户名密码不匹配");
            response.getWriter().print("用户名密码不对");
            response.setHeader("refresh","3;/login.htm");
        }
        else{
            response.getWriter().print(username+"欢迎回来");
            ServletContext servletContext = getServletContext();
                      Integer count = (Integer) servletContext.getAttribute("count");
                      count++;
                      servletContext.setAttribute("count",count);
            response.getWriter().println("总登录成功次数："+count);


                  }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(username+password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
