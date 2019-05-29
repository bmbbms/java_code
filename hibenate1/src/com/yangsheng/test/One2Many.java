package com.yangsheng.test;

import com.yangsheng.domain.Customer;
import com.yangsheng.domain.LinkMan;
import com.yangsheng.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import sun.security.ssl.HandshakeInStream;

public class One2Many {

    @Test
    public  void testone2many(){

        Session session =  HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //核心操作表
        Customer customer = new Customer();
        customer.setCust_name("guao");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkm_name("haha");

        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkm_name("ys");

        customer.getLinkMans().add(linkMan);
        customer.getLinkMans().add(linkMan1);


        linkMan.setCustomer(customer);
        linkMan1.setCustomer(customer);

        session.save(customer);
        session.save(linkMan);
        session.save(linkMan1);


        transaction.commit();
        session.close();
    }


    /*
        增加联系人
     */
    @Test
    public  void testone2many1(){

        Session session =  HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer cm1 = new Customer();
        cm1.setCust_name("ys");

        LinkMan lm1 = new LinkMan();
        lm1.setLkm_name("hh");

        LinkMan lm2 = new LinkMan();
        lm2.setLkm_name("hha");

        cm1.getLinkMans().add(lm1);
        cm1.getLinkMans().add(lm2);
        lm1.setCustomer(cm1);
        lm2.setCustomer(cm1);


        session.save(cm1);
        transaction.commit();
        session.close();
    }
}
