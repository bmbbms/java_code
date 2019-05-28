package com.yangsheng.test;

import com.yangsheng.domain.Customer;
import com.yangsheng.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestCache {
    @Test
    public void f1(){
        Session session = HibernateUtils.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 1L);

        customer.setCust_name("a");


        transaction.commit();

        session.close();


    }

    @Test
    public void f2(){
        Session session = HibernateUtils.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();

        customer.setCust_id(1L);
        customer.setCust_name("ys1");
        session.update(customer);


        session.get(Customer.class, 1L);





        transaction.commit();

        session.close();


    }
}
