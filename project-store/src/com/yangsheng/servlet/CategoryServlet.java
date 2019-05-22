package com.yangsheng.servlet;

import com.yangsheng.bean.Category;
import com.yangsheng.dao.impl.CategoryDaoImpl;
import com.yangsheng.service.CategoryService;
import com.yangsheng.service.impl.CategoryServiceImpl;
import com.yangsheng.util.BeanFactory;
import com.yangsheng.util.JsonUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet(urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {

	/**
	 * 查询所有的分类
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// 1.调用categoryservice 查询所有的分类 返回值list

		 CategoryService cs = new CategoryServiceImpl();


//		CategoryService cs = (CategoryService) BeanFactory.getBean("CategoryService");
		List<Category> clist = null;
		try {
			clist = cs.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2.将返回值转成json格式 返回到页面上
		//request.setAttribute("clist", clist);
		String json = JsonUtil.list2json(clist);
		
		//3.写回去
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(json);
		
		return null;
	}

}
