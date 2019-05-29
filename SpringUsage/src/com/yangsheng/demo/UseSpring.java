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

import com.yangsheng.service.UserService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/29
 * @since 1.0.0
 */
public class UseSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.sayHello();

    }
}