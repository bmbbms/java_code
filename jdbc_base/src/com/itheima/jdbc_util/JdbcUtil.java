/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: JdbcUtil
 * Author:   bmbbms
 * Date:     2019/5/7 15:12
 * Description: jdbc_util
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.itheima.jdbc_util;


import java.sql.*;

/**
 * 〈一句话功能简述〉<br/>
 * 〈jdbc_util〉
 *
 * @author bmbbms
 * @create 2019/5/7
 * @since 1.0.0
 */
public class JdbcUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
        return conn;
    }

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {

        closeResultSet(rs);
        closePrepareStatment(ps);
        closeConn(conn);
    }

    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        conn = null;
    }

    public static void closePrepareStatment(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ps = null;
    }


    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        rs = null;
    }
}