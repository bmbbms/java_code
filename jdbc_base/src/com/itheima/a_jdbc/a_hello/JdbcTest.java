/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: JdbcTest
 * Author:   bmbbms
 * Date:     2019/5/7 14:37
 * Description: test_jdbc
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.itheima.a_jdbc.a_hello;

import com.itheima.jdbc_util.JdbcUtil;
import com.itheima.jdbc_util.JdbcUtilNew;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;

import java.sql.*;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈test_jdbc〉
 *
 * @author bmbbms
 * @create 2019/5/7
 * @since 1.0.0
 */
public class JdbcTest {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

        //3.编写sql语句
        String sql = "select * from category";

        //4.创建语句执行者
        PreparedStatement ps = conn.prepareStatement(sql);

        // 5. 执行mysql
        ResultSet rs = ps.executeQuery();

        //6.处理结果
        while (rs.next()) {
            System.out.println(rs.getString("cid") + ":" + rs.getString("cname"));
        }

        //7.释放资源
        rs.close();
        ps.clearParameters();
        conn.close();
    }

    @Test
    public void f1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 1.获取连接
        try {
            conn = JdbcUtilNew.getConnection();
            // 2. 编写sql
            String sql = "insert into category values(?,?)";
            //3. 创造执行者
            ps = conn.prepareStatement(sql);
            ps.setString(1, "c006");
            ps.setString(2, "户外");

            //4.执行sql
            int change_one = ps.executeUpdate();
            if (change_one == 1) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilNew.closeResource(conn, ps, rs);
        }


    }

    @Test
    public void update() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = JdbcUtilNew.getConnection();
            //设置sql
            String sql = "update category set cname= ? where cid= ?";

            //创造语句执行者
            st = conn.prepareStatement(sql);

            //设置参数
            st.setString(1, "手机");
            st.setString(2, "c005");
            // 执行sql
            int change_one = st.executeUpdate();
            if (change_one == 1) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilNew.closeResource(conn, st, rs);
        }


    }

    @Test
    public  void delete(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
             conn = JdbcUtilNew.getConnection();

             String sql = "DELETE FROM category where cid = ?";

             ps = conn.prepareStatement(sql);

             ps.setString(1,"c006");

            int change_one = ps.executeUpdate();

            if(change_one == 1){
                System.out.println("success");
            }else
            {
                System.out.println("fail");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtilNew.closeResource(conn,ps,rs);
        }
    }
}