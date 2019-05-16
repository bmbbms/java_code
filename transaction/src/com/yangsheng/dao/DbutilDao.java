/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: DbutilDao
 * Author:   bmbbms
 * Date:     2019/5/15 14:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.dao;

import com.yangsheng.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/15
 * @since 1.0.0
 */
public class DbutilDao {
    public void accountIn(String toUser, String money) throws SQLException {
        final QueryRunner qr = new QueryRunner();
        String sql = "update  account1 set money = money + ? where name = ?";
        qr.update(DataSourceUtils.getConnection(),sql,money,toUser);
    }

    public void accountOut(String fromUser, String money) throws SQLException {
         final QueryRunner qr = new QueryRunner();
        String sql = "update  account1 set money = money - ? where name = ?";
        qr.update(DataSourceUtils.getConnection(),sql,money,fromUser);
    }
}