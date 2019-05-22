/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: CategoryServiceImpl
 * Author:   bmbbms
 * Date:     2019/5/21 15:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.service.impl;

import com.yangsheng.bean.Category;
import com.yangsheng.dao.CategoryDao;
import com.yangsheng.dao.impl.CategoryDaoImpl;
import com.yangsheng.service.CategoryService;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/21
 * @since 1.0.0
 */
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> findAll() throws SQLException {
        CategoryDao dao = new CategoryDaoImpl();
        List<Category> clist = dao.findAll();
        return clist;
    }
}