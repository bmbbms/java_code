package com.yangsheng.servlet;

import com.yangsheng.Conventer.MyConventer;
import com.yangsheng.bean.User;
import com.yangsheng.contant.Contant;
import com.yangsheng.service.UserService;
import com.yangsheng.service.impl.UserServiceImpl;
import com.yangsheng.util.MD5Utils;
import com.yangsheng.util.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/21 10:51
 **/
@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "/jsp/register.jsp";

    }


    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException, SQLException, MessagingException {
        //1.封装数据
        User user = new User();

        //注册自定义转换器
        ConvertUtils.register(new MyConventer(), Date.class);
        BeanUtils.populate(user, request.getParameterMap());

        //设置用户ID
        user.setUid(UUIDUtils.getId());
        //设置激活码
        user.setCode(UUIDUtils.getCode());

        //设置密码
        user.setPassword(MD5Utils.md5(user.getPassword()));

        //2.调用service完成注册
        UserService us = new UserServiceImpl();
        us.register(user);

        //3.页面请求转发


        return "/jsp/msg.jsp";

    }


    public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException, SQLException, MessagingException {
        String code = request.getParameter("code");
        UserService us = new UserServiceImpl();
        User user = us.active(code);
        if (user == null) {
            request.setAttribute("msg", "请重新激活");
        } else {
            //添加信息
            request.setAttribute("msg", "激活成功");
        }
        //3.请求转发到msg.jsp

        return "/jsp/msg.jsp";


    }


    public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "/jsp/login.jsp";

    }

    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = MD5Utils.md5(password);

        //2.调用serive完成登录操作 返回user
        UserService s = new UserServiceImpl();
        User user = s.login(username, password);

        //3.判断user
        if (user == null) {
            request.setAttribute("msg", "用户名密码不匹配");
            return "/jsp/login.jsp";
        } else {
            if (Contant.USER_IS_ACTIVE != user.getState()) {
                request.setAttribute("msg", "用户未激活");
                return "/jsp/login.jsp";
            }
        }

        request.getSession().setAttribute("user", user);
        response.sendRedirect(request.getContextPath() + "/");//  /store
        return null;
    }

    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();

        //store

        response.sendRedirect(request.getContextPath() + "/");

        return null;

    }
}