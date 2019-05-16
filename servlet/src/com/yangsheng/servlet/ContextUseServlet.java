package com.yangsheng.servlet;




import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/13 11:55
 **/
@WebServlet(name = "ContextUseServlet",urlPatterns = "/context")
public class ContextUseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
        InputStream is = servletContext.getResourceAsStream("a.txt");
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(is, os);

    }
}
