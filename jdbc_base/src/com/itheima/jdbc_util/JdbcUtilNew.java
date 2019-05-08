/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: JdbcUtilNew
 * Author:   bmbbms
 * Date:     2019/5/7 15:58
 * Description: new Util for jdbc
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.itheima.jdbc_util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈new Util for jdbc〉
 *
 * @author bmbbms
 * @create 2019/5/7
 * @since 1.0.0
 */
public class JdbcUtilNew {
    static String DRIVERCLASS;
    static String USER;
    static String PASSWORD;
    static String URL;

    static{
        ResourceBundle dbcp = ResourceBundle.getBundle("dbcp");
        DRIVERCLASS = dbcp.getString("driverClassName");
        USER = dbcp.getString("username");
        PASSWORD = dbcp.getString("password");
        URL = dbcp.getString("url");

    }

    static {
        try {
            Class.forName(DRIVERCLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  public static Connection getConnection() throws ClassNotFoundException, SQLException {



      return DriverManager.getConnection(URL,USER,PASSWORD);

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