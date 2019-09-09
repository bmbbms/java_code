/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserServiceImpl
 * Author:   bmbbms
 * Date:     2019/6/3 13:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.service;

import com.yangsheng.dao.UserDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    private TransactionTemplate transactionTemplate;

    @Override
    public void pay(String in, String out, Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        userDao.acount_in(in,money);
                        userDao.acount_out(out,money);
            }
        });

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
}