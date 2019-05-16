package com.yangsheng.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/13 11:41
 **/
@WebServlet(name = "ConfigServlet",urlPatterns = "/config",initParams = {
        @WebInitParam(name = "username",value = "tom"),
        @WebInitParam(name = "password", value = "123")
})
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        config.getServletContext();


        String username = config.getInitParameter("username");
        System.out.println("单一变量："+username);

        Enumeration<String> initParameterNames = config.getInitParameterNames();

        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            System.out.println("名称" + name + config.getInitParameter(name));

        }
    }
}
