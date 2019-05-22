package com.yangsheng.service;

import com.yangsheng.bean.User;

import javax.mail.MessagingException;
import java.sql.SQLException;

/**
 * @author: yangsheng
 * @Email: 891765948@qq.com
 * @date: 2019/5/21 11:23
 **/
public interface UserService {
    void register(User user) throws SQLException, MessagingException;

    User active(String code) throws SQLException;

    User login(String username, String password) throws SQLException;
}
