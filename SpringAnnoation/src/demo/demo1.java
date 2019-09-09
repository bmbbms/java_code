/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: demo1
 * Author:   bmbbms
 * Date:     2019/6/3 8:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserDao;
import service.UserService;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
public class demo1 {
    @Test
    public  void f1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService us = (UserService) ac.getBean("userService");
        us.save();
    }

     @Test
    public  void f2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserDao us = (UserDao) ac.getBean("userdao");
        us.save();
    }
}