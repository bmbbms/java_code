package com.yangsheng.dao;

import com.yangsheng.bean.User;

import java.sql.SQLException;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/21 11:26
 **/
public interface UserDao {
    void add(User user) throws SQLException;

    User getByCode(String code) throws SQLException;

    void update(User user) throws SQLException;

    User getUserByNameAndPassword(String username, String password) throws SQLException;
}
