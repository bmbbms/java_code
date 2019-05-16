/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserDao
 * Author:   bmbbms
 * Date:     2019/5/13 9:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.dao;

import com.yangsheng.bean.User;
import com.yangsheng.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/13
 * @since 1.0.0
 */
public class UserDao {

    public  User getUsernameAndPassword(String username, String password) throws SQLException {


        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from user where username=? and password=? ";

        User user = queryRunner.query(sql, new BeanHandler<>(User.class),username,password);


        return user;
    }

}