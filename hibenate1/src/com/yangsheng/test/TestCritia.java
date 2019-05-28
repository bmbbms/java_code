package com.yangsheng.test;

import com.yangsheng.domain.Customer;
import com.yangsheng.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class TestCritia {

    @Test

    public void allselect(){
        Session session = HibernateUtils.openSession();
        Transaction transaction =  session.beginTransaction();

        Criteria criteria =   session.createCriteria(Customer.class);

//        criteria.add(Restrictions.eq("cust_id",1L));
//        Customer c = (Customer) criteria.uniqueResult();


        criteria.setFirstResult(0);
        criteria.setMaxResults(1);

        List<Customer> list = criteria.list();
        System.out.println(list);


        transaction.commit();
        session.close();
    }
}
