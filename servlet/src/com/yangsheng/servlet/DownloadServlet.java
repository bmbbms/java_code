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
 * @date: 2019/5/13 17:42
 **/
@WebServlet(name = "DownloadServlet",urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ServletContext cont = getServletContext();
        String filename = request.getParameter("name");
//        filename = new String(filename.getBytes("iso8859-1"), "utf-8");
        System.out.println(filename.getBytes());
        String mimeType = cont.getMimeType(filename);
        response.setContentType(mimeType);

        response.setHeader("content-disposition","attchment;filname="+filename);

        ServletOutputStream os =   response.getOutputStream();

        InputStream is = cont.getResourceAsStream(filename);

        IOUtils.copy(is,os);


    }
}
