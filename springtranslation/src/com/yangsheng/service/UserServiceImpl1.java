/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserServiceImpl1
 * Author:   bmbbms
 * Date:     2019/6/3 14:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.service;

import com.yangsheng.dao.UserDao;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
public class UserServiceImpl1 implements UserService {
    private UserDao userDao;
    @Override
    public void pay(String in, String out, Double money) {
        userDao.acount_in(in,money);
        userDao.acount_out(out,money);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}