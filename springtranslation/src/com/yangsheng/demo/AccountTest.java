/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: AccountTest
 * Author:   bmbbms
 * Date:     2019/6/3 13:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.demo;

import com.yangsheng.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class AccountTest {
    @Resource(name = "userservice")
    private UserService userService;

    @Resource(name = "userservice1")
    private UserService userService1;

    @Resource(name = "userservice2")
    private UserService userService2;

    @Test
    public void run(){
        userService.pay("aa","bb",1000d);
    }
      @Test
    public void run1(){
        userService1.pay("aa","bb",1000d);
    }

          @Test
    public void run2(){
        userService2.pay("aa","bb",1000d);
    }



}