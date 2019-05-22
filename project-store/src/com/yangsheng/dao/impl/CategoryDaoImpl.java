/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: CategoryDaoImpl
 * Author:   bmbbms
 * Date:     2019/5/21 15:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.dao.impl;

import com.yangsheng.bean.Category;
import com.yangsheng.dao.CategoryDao;
import com.yangsheng.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
public class CategoryDaoImpl implements CategoryDao {
    public static void main(String[] args) {

    }

    @Override
    public List<Category> findAll() throws SQLException {
         QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

         String sql = "select * from category";

         List <Category> clist = qr.query(sql, new BeanListHandler <>(Category.class));

         return clist;
    }
}