package com.itheima.dbutil;

import com.itheima.bean.Category;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DbUtilDemo {
    @Test
    public  void dbutil() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "Delete from category where cid = ?";

        qr.update(sql,"c008");
    }
    @Test
    public void resultSetHandles() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from category";

        //listHandler
        List<Object[]> list1 = qr.query(sql, new ArrayListHandler());
        for(Object[] obj: list1)
        {
            System.out.println(Arrays.toString(obj));

        }

        //beanListHandler
        List<Category> beanQr = qr.query(sql, new BeanListHandler<>(Category.class));
        for(Category cBean : beanQr){
            System.out.println(cBean);
        }

        List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
        for(Map<String,Object> one:query){
//            System.out.println(one);
//            System.out.println(one.get("cid"));
            for(Object value : one.values()){
                System.out.println(value);
            }
        }

        String sql1 = "select count(*) from category";
        Object query1 = qr.query(sql1, new ScalarHandler());
        System.out.println(query1);
    }
}
