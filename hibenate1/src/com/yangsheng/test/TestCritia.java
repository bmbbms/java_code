package com.yangsheng.test;

import com.yangsheng.domain.Customer;
import com.yangsheng.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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



    @Test

    public void allselect1(){
        Session session = HibernateUtils.openSession();
        Transaction transaction =  session.beginTransaction();

        CriteriaQuery<Customer> criteria = session.getCriteriaBuilder().createQuery(Customer.class);

//        criteria.add(Restrictions.eq("cust_id",1L));
//        Customer c = (Customer) criteria.uniqueResult();
        Root<Customer> root = criteria.from(Customer.class);
        Query<Customer> query = session.createQuery(criteria);
        List<Customer> resultList = query.getResultList();
        System.out.println(resultList);
        System.out.println(root.get("cust_id"));




        transaction.commit();
        session.close();
    }
}
