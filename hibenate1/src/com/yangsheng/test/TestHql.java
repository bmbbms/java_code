package com.yangsheng.test;

import com.yangsheng.domain.Customer;
import com.yangsheng.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class TestHql {

    @Test
    public void allselect(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from com.yangsheng.domain.Customer";
        Query query = session.createQuery(hql);

        List<Customer> list = query.list();

        for(Customer c : list){
            System.out.println(c.getCust_id());
        }
        System.out.println(list);


        transaction.commit();
        session.close();

    }

    @Test
    public void inplace(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from Customer where cust_id =:id";

        Query query = session.createQuery(hql);
        query.setParameter("id",1L);

        Customer c = (Customer) query.uniqueResult();

        System.out.println(c);


        transaction.commit();
        session.close();

    }


    @Test
    public void page(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from Customer";

        Query query = session.createQuery(hql);
        query.setFirstResult(1);
        query.setMaxResults(1);

        Customer c = (Customer) query.uniqueResult();

        System.out.println(c);


        transaction.commit();
        session.close();

    }



}
