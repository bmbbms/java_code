package com.yangsheng.test;

import com.yangsheng.domain.Customer;
import com.yangsheng.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.Test;
import sun.security.ssl.HandshakeInStream;

import java.util.List;

public class TestSql {

    @Test
    public void allselect(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String sql ="select * from cst_customer";

        NativeQuery sqlQuery = session.createSQLQuery(sql);

        sqlQuery.addEntity(Customer.class);

        List <Customer> list = sqlQuery.list();
        System.out.println(list);


        transaction.commit();
        session.close();

    }

    @Test
    public void contion(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String sql ="select * from cst_customer ";

        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setFirstResult(0);
        sqlQuery.setMaxResults(1);
//        sqlQuery.setParameter("id", 1L);
        sqlQuery.addEntity(Customer.class);

        List <Customer> list = sqlQuery.list();
        System.out.println(list);


        transaction.commit();
        session.close();

    }
}
