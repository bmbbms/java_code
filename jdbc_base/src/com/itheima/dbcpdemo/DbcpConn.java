package com.itheima.dbcpdemo;

import com.itheima.jdbc_util.JdbcUtilNew;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpConn {

    /***
     * 硬编码
     */
    @Test
    public void hotdbcp() throws SQLException {
            //获取连接池配置
            BasicDataSource ds = new BasicDataSource();

            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl("jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf-8");
            ds.setUsername("root");
            ds.setPassword("Bmb!123456");

            // 获取连接
            Connection conn =  ds.getConnection();

            // sql
            String sql = "insert into category values(?,?)";

            //创建语句执行者
            PreparedStatement ps = conn.prepareStatement(sql);

            //设置参数
            ps.setString(1,"c010");
            ps.setString(2,"外网");

        long change_one = ps.executeUpdate();

        System.out.println(change_one);

        JdbcUtilNew.closeResource(conn,ps,null);
        }


    @Test
    public void softdbcp() throws Exception {
        //获取配置信息
        Properties prop = new Properties();
        prop.load(new FileInputStream("/Users/yangsheng/java_code/javaweb/jdbc_base/src/dbcp.properties"));


//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf-8");
//        ds.setUsername("root");
//        ds.setPassword("Bmb!123456");

        // 获取连接
        new BasicDataSourceFactory();
        DataSource ds = BasicDataSourceFactory.createDataSource(prop);
        Connection conn = ds.getConnection();
        // sql
        String sql = "insert into category values(?,?)";

        //创建语句执行者
        PreparedStatement ps = conn.prepareStatement(sql);

        //设置参数
        ps.setString(1,"c011");
        ps.setString(2,"网吧");

        long change_one = ps.executeUpdate();

        System.out.println(change_one);

        JdbcUtilNew.closeResource(conn,ps,null);
    }



}
