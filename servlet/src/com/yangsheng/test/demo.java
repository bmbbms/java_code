/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: demo
 * Author:   bmbbms
 * Date:     2019/5/15 11:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.test;

import com.yangsheng.bean.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/15
 * @since 1.0.0
 */
public class demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class conn = Class.forName("com.yangsheng.bean.Person");

        Class  personClass = Person.class;
        Method eat = conn.getDeclaredMethod("eat");

        eat.setAccessible(true);

        eat.invoke(conn.newInstance());
    }
}