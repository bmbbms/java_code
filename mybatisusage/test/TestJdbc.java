/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: TestJdbc
 * Author:   bmbbms
 * Date:     2019/6/11 13:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.sql.*;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/11
 * @since 1.0.0
 */
public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            //JDBC使用步骤
            /**
             * 1. 加载驱动
             * 2.通过驱动管理器获取连接
             * 3. 书写sql语句
             * 4.通过连接获取prepareStatement
             * 5.执行语句
             * 6.处理返回结果
             *  7. 关闭连接
             */
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "root");
            String sql = "select * from user ";
             ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString("id") + resultSet.getString("username"));
            }


        } catch (SQLException e) {

        }

    }
}