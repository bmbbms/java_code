/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: ProxyUtil
 * Author:   bmbbms
 * Date:     2019/6/3 9:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
public class ProxyUtil {
   public static  UserService getProxy(final UserService userService){
       /**
        * 使用jDK自带的Proxy类进行动态代理实现，前提需要有接口
        */
       UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               if ("save".equals(method.getName())) {
                   System.out.println("记录日志");
               }
               return method.invoke(userService, args);
           }
       });
       return proxy;
   }
}