package com.yangsheng.test;

import com.yangsheng.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestHibernate {

    /***
     * hibernate 增方法
     * @param args
     */
    public static void main(String[] args) {
        Configuration cf = new Configuration().configure();
        SessionFactory sessionFactory = cf.buildSessionFactory();

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

    /**
     * hibernate 查方法
     */
    @Test
    public  void f1(){
        Configuration cf = new Configuration().configure();
        SessionFactory sessionFactory = cf.buildSessionFactory();

        Session session =   sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();



        Customer customer1 = session.get(Customer.class, 1L);

        System.out.println(customer1);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }

    /*
        hibernate 改方法
     */

    @Test
    public void f2(){
        Configuration cf = new Configuration().configure();
        SessionFactory sessionFactory = cf.buildSessionFactory();

        Session session =   sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();



        Customer customer1 = session.get(Customer.class, 1L);

        customer1.setCust_name("ys1");

        session.update(customer1);

        transaction.commit();
        session.close();
        sessionFactory.close();


    }


    /**
     * 删除方法
     */
    @Test
    public void f3(){

        Configuration cf = new Configuration().configure();
        SessionFactory sessionFactory = cf.buildSessionFactory();

        Session session =   sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();



        Customer customer1 = session.get(Customer.class, 1L);



        session.delete(customer1);
        transaction.commit();
        session.close();
        sessionFactory.close();



    }

}
