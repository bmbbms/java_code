package com.yangsheng.cookiesession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/14 14:09
 **/
@WebServlet(name = "CookieServlet",urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter os = response.getWriter();
        Cookie cookie = new Cookie("username", "yangsheng");
        Cookie lastTime  = getCookieByName("lastTime", request.getCookies());

        if(lastTime == null){

            os.println("这是您第一次访问");
        }else {
            String value = lastTime.getValue();
            long l = Long.parseLong(value);
            Date date = new Date(l);
            os.println("您上次访问时间为:"+date.toLocaleString());


        }

        Cookie lastTime1 = new Cookie("lastTime", new Date().getTime() + "");
        response.addCookie(lastTime1);
        cookie.setMaxAge(3600);



        response.addCookie(cookie);


    }

    /**
     * 通过cookie键找到cookie
     * @param lastTime
     * @param cookies
     * @return
     */
    private Cookie getCookieByName(String lastTime, Cookie[] cookies) {
        for(Cookie c : cookies){
            if(lastTime.equals(c.getName())){
                return c;
            }
        }
        return null;
    }
}
