/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserDaoImpl
 * Author:   bmbbms
 * Date:     2019/6/3 13:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sound.midi.spi.SoundbankReader;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{

    @Override
    public void acount_in(String in, double money) {
        this.getJdbcTemplate().update("UPDATE  t_account SET money = money + ? where name = ? ",money,in);

    }

    @Override
    public void acount_out(String out, double money) {
    this.getJdbcTemplate().update("UPDATE  t_account SET money = money - ? where name = ? ",money,out);
    }
}