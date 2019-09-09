/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: HibernateTest
 * Author:   bmbbms
 * Date:     2019/6/3 17:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yang.demo;

import com.yang.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
public class HibernateTest {
    @Test
    public void f1(){
        Configuration cf1 = new Configuration().configure();
        SessionFactory sessionFactory = cf1.buildSessionFactory();

        Session session =   sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("yangsheng");
        customer.setCust_industry("wtf");
        customer.setCust_level("2");

        session.save(customer);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }


}