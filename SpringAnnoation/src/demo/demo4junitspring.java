/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: demo4junitspring
 * Author:   bmbbms
 * Date:     2019/6/3 8:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */

/**
 *结合junit和spring
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class demo4junitspring {
    @Resource(name = "userService")
    private  UserService user;
    @Test
    public void demo1(){
        user.save();
    }



}