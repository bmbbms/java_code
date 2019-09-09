/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: ProxyDemo
 * Author:   bmbbms
 * Date:     2019/6/3 9:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CGLIBUtil;
import service.ProxyUtil;
import service.UserService;
import service.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
public class ProxyDemo {

    @Test
    public void f1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        final  UserService us = (UserService) ac.getBean("userService");
        us.save();
        System.out.println("====================");
        UserService proxy = ProxyUtil.getProxy(us);
        proxy.save();
    }
     @Test
    public void f2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserServiceImpl us = (UserServiceImpl) ac.getBean("userService");
        us.save();
        System.out.println("====================");
        UserService proxy = CGLIBUtil.getProxy(us);
        proxy.save();
    }
}