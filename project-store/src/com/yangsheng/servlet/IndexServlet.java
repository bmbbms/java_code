package com.yangsheng.servlet;


import com.yangsheng.bean.Category;
import com.yangsheng.service.CategoryService;
import com.yangsheng.service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 和首页相关的servlet
 */
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends BaseServlet {
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//去数据库中查询最新商品和热门商品  将他们放入request域中 请求转发


		CategoryService cs = new CategoryServiceImpl();
		List<Category> clist = cs.findAll();
		System.out.println("h1");
		if (clist.size()>0){
			System.out.println("buhui");
		}
		else{
			System.out.println("hh");
		}


		request.setAttribute("clist", clist);


		return "/jsp/index.jsp";
	}

}
