/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserDaoImpl
 * Author:   bmbbms
 * Date:     2019/6/3 17:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yang.dao;

import com.yang.domain.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public void save(Customer customer) {
        System.out.println("持久层");
        this.getHibernateTemplate().save(customer);

    }
}