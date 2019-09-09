/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: TestDao
 * Author:   bmbbms
 * Date:     2019/6/13 11:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.test;

import com.yangsheng.dao.UserDao;
import com.yangsheng.mapper.UserMapper;
import com.yangsheng.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/13
 * @since 1.0.0
 */
public class TestMapper {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
 @Before
 public void setup(){
     classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
 }
 @Test
    public void find1(){
     UserMapper userMapper = (UserMapper) classPathXmlApplicationContext.getBean("userMapper");

     User user = userMapper.findUserById(1);

     System.out.println(user);
 }
}