/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: JdbcDao
 * Author:   bmbbms
 * Date:     2019/5/15 13:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.dao;

import com.yangsheng.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/15
 * @since 1.0.0
 */
public class JdbcDao {
    public  void accountIn(Connection conn, String toUser, String money) {
        PreparedStatement ps = null;


        try{
         String sql = "update  account set money = money +? where name = ?";
         ps = conn.prepareStatement(sql);
         ps.setString(1,money);
         ps.setString(2,toUser);

         int i = ps.executeUpdate();
            System.out.println(toUser+" 进"+ money);

    } catch (SQLException e){
            e.printStackTrace();
            JdbcUtils.closeStatement(ps);
        }
    }


     public  void accountOut(Connection conn, String fromUser, String money){
                PreparedStatement ps = null;


        try{
         String sql = "update  account set money = money -? where name = ?";
         ps = conn.prepareStatement(sql);
         ps.setString(1,money);
         ps.setString(2,fromUser);

         int i = ps.executeUpdate();
            System.out.println(fromUser+" 出"+ money);

    } catch (SQLException e){
            e.printStackTrace();
            JdbcUtils.closeStatement(ps);
        }
    }
}