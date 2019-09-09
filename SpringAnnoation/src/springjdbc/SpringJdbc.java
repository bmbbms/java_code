/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: SpringJdbc
 * Author:   bmbbms
 * Date:     2019/6/3 11:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package springjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.lang.Nullable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJdbc {
    	@Test
		public void run1(){
			// 创建连接池，先使用Spring框架内置的连接池
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql:///spring?characterEncoding=utf-8");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			// 创建模板类
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// 完成数据的添加
			jdbcTemplate.update("insert into t_account values (null,?,?)", "测试",10000);
		}


		@Resource(name="jdbcTemplate")
		private JdbcTemplate jdbcTemplate;

	/**
	 * 插入操作
	 */
	@Test
		public void run2(){
			jdbcTemplate.update("insert into t_account values (null,?,?)", "测试2",10000);
		}

			/**
	 * 删除操作
	 */
	@Test
		public void run3(){
			jdbcTemplate.update("DELETE From t_account where id = ?", 3);
		}
	/**
	 * X修改操作
	 */
	@Test
		public void run4(){
			jdbcTemplate.update("UPDATE t_account Set name = ? ,money = ? where id = ?", "yangsheng",1000d,4);
		}

			/**
	 * 查询 一条操作
	 */
	@Test
		public void run5(){
		Account account = jdbcTemplate.queryForObject("select * FROM t_account where id = ?", new BeanMapper(), 4);
		System.out.println(account);
	}

	@Test
		public void run6() {
		List <Account> account = jdbcTemplate.query("select * FROM t_account ", new BeanMapper());
		for (Account a : account) {
			System.out.println(a);
		}

	}



	private class BeanMapper implements RowMapper<Account> {
		@Nullable
		@Override
		public Account mapRow(ResultSet resultSet, int i) throws SQLException {
			Account account = new Account();
			account.setMoney(resultSet.getDouble("money"));
			account.setId(resultSet.getInt("id"));
			account.setName(resultSet.getString("name"));

			return account;
		}
	}
}