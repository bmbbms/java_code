/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: Many2Many
 * Author:   bmbbms
 * Date:     2019/5/29 9:12
 * Description: 多对多
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.test;

import com.yangsheng.domain.Role;
import com.yangsheng.domain.User;
import com.yangsheng.util.HibernateUtils;
import net.bytebuddy.build.ToStringPlugin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈多对多〉
 *
 * @author bmbbms
 * @create 2019/5/29
 * @since 1.0.0
 */
public class Many2Many {

    @Test
    public  void f1(){

        Session session = HibernateUtils.openSession();

        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUser_name("ys");

        User user1 = new User();
        user1.setUser_name("ys1");

        Role role = new Role();
        role.setRole_name("员工");

        Role role1 = new Role();
        role1.setRole_name("官员");

//        user.getRoles().add(role);
//        user.getRoles().add(role1);
//
//        user1.getRoles().add(role);
//        user1.getRoles().add(role1);

        role.getUsers().add(user);
        role.getUsers().add(user1);

        role1.getUsers().add(user);
        role1.getUsers().add(user1);

//        session.save(user);
//        session.save(user1);
        session.save(role);
        session.save(role1);

        transaction.commit();
        session.close();




    }


}