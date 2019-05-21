package com.itheima.c3podemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3p0Demo {
    @Test
    public void hotc3p0() throws SQLException, PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf-8");
        ds.setUser("root");
        ds.setPassword("Bmb!123456");
        Connection conn = ds.getConnection();


        // sql
        String sql = "update  category set cname = ? where cid = ?";

        //创建语句执行者
        PreparedStatement ps = conn.prepareStatement(sql);

        //设置参数
        ps.setString(1,"被子");
        ps.setString(2,"c008");

        long change_one = ps.executeUpdate();

        System.out.println(change_one);

    }

    @Test
    public void softc3p0() throws SQLException, PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();

        Connection conn = ds.getConnection();


        // sql
        String sql = "update  category set cname = ? where cid = ?";

        //创建语句执行者
        PreparedStatement ps = conn.prepareStatement(sql);

        //设置参数
        ps.setString(1,"袜子");
        ps.setString(2,"c009");

        long change_one = ps.executeUpdate();

        System.out.println(change_one);

    }



}
