package com.yangsheng.test;

import com.yangsheng.domain.Customer;
import com.yangsheng.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.logging.Handler;

public class TestCurentSession {
    @Test
    public void f1(){

        Session currentSession = HibernateUtils.getCurrentSession();
        Session currentSession1 = HibernateUtils.getCurrentSession();
        System.out.println(currentSession==currentSession1);



    }
    @Test
    public void f2(){
        Session currentSession = HibernateUtils.getCurrentSession();

        Transaction transaction = currentSession.beginTransaction();

        Customer customer = currentSession.get(Customer.class, 1L);

        System.out.println(customer);

        transaction.commit();


    }
}
