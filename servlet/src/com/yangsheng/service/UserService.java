/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserService
 * Author:   bmbbms
 * Date:     2019/5/13 9:44
 * Description: 处理用户的服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.service;

import com.yangsheng.bean.User;
import com.yangsheng.dao.UserDao;

import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈处理用户的服务〉
 *
 * @author bmbbms
 * @create 2019/5/13
 * @since 1.0.0
 */
public class UserService {
    public User login(String username, String password) throws SQLException {
        UserDao dao = new UserDao();
        return dao.getUsernameAndPassword(username,password);
    }
}