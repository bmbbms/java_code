/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: TestUtil
 * Author:   bmbbms
 * Date:     2019/5/13 10:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.test;

import com.yangsheng.bean.User;
import com.yangsheng.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/13
 * @since 1.0.0
 */
public class TestUtil {
  @Test
  public void dbutil() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from user where username=? and password=? ";

        User user = queryRunner.query(sql, new BeanHandler<>(User.class),"tom","123");
    System.out.println(user.getId());
    System.out.println(user.getUsername());


  }
}