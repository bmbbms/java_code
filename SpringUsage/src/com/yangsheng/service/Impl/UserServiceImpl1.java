/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserServiceImpl
 * Author:   bmbbms
 * Date:     2019/5/29 14:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.service.Impl;

import com.yangsheng.dao.UserDao;
import com.yangsheng.service.UserService;
import com.yangsheng.service.UserService1;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/29
 * @since 1.0.0
 */
public class UserServiceImpl1 implements UserService1 {


    private UserDao userDao;
    private String name;

    public UserServiceImpl1(UserDao userDao, String name) {
        this.userDao = userDao;
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("say hello" +name);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save(){
        userDao.save();
        System.out.println("业务层");
    }
}