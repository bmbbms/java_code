package com.yangsheng.service;

import com.yangsheng.bean.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/21 15:22
 **/
public interface CategoryService {
    List <Category> findAll() throws SQLException;
}
