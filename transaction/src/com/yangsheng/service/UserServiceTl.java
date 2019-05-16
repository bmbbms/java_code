/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserServiceTl
 * Author:   bmbbms
 * Date:     2019/5/15 13:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.service;

import com.yangsheng.dao.DbutilDao;
import com.yangsheng.util.DataSourceUtils;

import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/15
 * @since 1.0.0
 */
public class UserServiceTl {

    public void account(String fromUser, String toUser, String money)  {
        final DbutilDao dao = new DbutilDao();
        try {
            DataSourceUtils.startTransaction();
            dao.accountIn(toUser, money);
            dao.accountOut(fromUser, money);

            DataSourceUtils.commitAndClose();
        }catch (SQLException e){
            e.printStackTrace();
            DataSourceUtils.rollbackAndClose();
        }

    }
}