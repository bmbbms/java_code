/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: SpringHibernate
 * Author:   bmbbms
 * Date:     2019/6/3 18:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yang.demo;

import com.yang.domain.Customer;
import com.yang.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
public class SpringHibernate {
    @Test
    public void f2(){
        ClassPathXmlApplicationContext cf = new ClassPathXmlApplicationContext("ApplicationContext1.xml");
        UserService userservice = (UserService) cf.getBean("userservice");
        Customer customer = new Customer();
        customer.setCust_name("hh");
        customer.setCust_level("aa");
        userservice.save(customer);
    }
}