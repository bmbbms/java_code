/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserServiceImpl
 * Author:   bmbbms
 * Date:     2019/5/21 11:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.service.impl;

import com.yangsheng.bean.User;
import com.yangsheng.dao.UserDao;
import com.yangsheng.dao.impl.UserDaoImpl;
import com.yangsheng.service.UserService;
import com.yangsheng.util.MD5Utils;
import com.yangsheng.util.MailUtils;

import javax.mail.MessagingException;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/21
 * @since 1.0.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) throws SQLException, MessagingException {
      UserDao dao=new UserDaoImpl();
      dao.add(user);

      String emailMsg="欢迎您注册成我们的一员,<a href='http://localhost:8080/store/user?method=active&code="+user.getCode()+"'>点此激活</a>";
      MailUtils.sendMail(user.getEmail(),emailMsg);
    }

    @Override
    public User active(String code) throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user = dao.getByCode(code);
        if(user==null){
            return null;
        }

        user.setState(1);
        dao.update(user);


        return user;
    }

    @Override
    public User login(String username, String password) throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user = dao.getUserByNameAndPassword(username,password);
        return user;
    }


}