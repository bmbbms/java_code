package com.yangsheng.dao;

import com.yangsheng.bean.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/21 15:24
 **/
public interface CategoryDao {
    List<Category> findAll() throws SQLException;
}
