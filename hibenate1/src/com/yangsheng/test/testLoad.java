/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: testLoad
 * Author:   bmbbms
 * Date:     2019/5/29 10:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.test;

import com.yangsheng.domain.Customer;
import com.yangsheng.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/29
 * @since 1.0.0
 */
public class testLoad {
 @Test
    public void f1(){
     Session session = HibernateUtils.openSession();
     Transaction transaction = session.beginTransaction();

     Customer load = session.load(Customer.class, 1L);

     System.out.println(load);


 }
}