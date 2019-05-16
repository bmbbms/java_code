/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserService
 * Author:   bmbbms
 * Date:     2019/5/15 13:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.service;

import com.yangsheng.dao.JdbcDao;
import com.yangsheng.util.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/15
 * @since 1.0.0
 */
public class UserService {
    /***
     * 转账服务
     * @param fromUser
     * @param toUser
     * @param money
     */
    public void account(String fromUser, String toUser, String money) throws SQLException {

        final JdbcDao jdbcDao = new JdbcDao();

        Connection conn=null;
        try {
            conn = JdbcUtils.getConnection();

            conn.setAutoCommit(false);
            jdbcDao.accountIn(conn,toUser,money);

            jdbcDao.accountOut(conn,fromUser,money);

            conn.commit();

            JdbcUtils.closeConn(conn);

        } catch (SQLException e) {
            conn.rollback();
            JdbcUtils.closeConn(conn);
        }
    }
}