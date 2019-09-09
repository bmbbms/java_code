/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UseSpring
 * Author:   bmbbms
 * Date:     2019/5/29 14:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.demo;

import com.yangsheng.service.Impl.ListDemoImpl;
import com.yangsheng.service.UserService;
import com.yangsheng.service.UserService1;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/29
 * @since 1.0.0
 */
public class UseSpring1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService1 userService = (UserService1) ac.getBean("userService");
        userService.sayHello();
        userService.save();

    }
    @Test
    public void f1(){
          ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ListDemoImpl listdemo = (ListDemoImpl)ac.getBean("listDemo");
        System.out.println(listdemo);
    }

}