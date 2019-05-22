package com.yangsheng.servlet;

import com.yangsheng.service.UserService;
import com.yangsheng.service.UserServiceTl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/15 13:09
 **/
@javax.servlet.annotation.WebServlet(name = "AccountServlet",urlPatterns = "/account")
public class AccountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();

		//获取参数值
        String fromUser = request.getParameter("from");
        String toUser = request.getParameter("to");
        String money = request.getParameter("money");

        //            new UserService().account(fromUser,toUser,money);
        new UserServiceTl().account(fromUser,toUser,money);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
