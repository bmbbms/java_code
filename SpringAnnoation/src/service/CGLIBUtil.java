/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: CGLIBUtil
 * Author:   bmbbms
 * Date:     2019/6/3 9:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package service;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
public class CGLIBUtil {
    public static UserService getProxy(UserService userService){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userService.getClass());

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return (Object) methodProxy.invokeSuper(o,objects);
            }
        });
        UserService o = (UserService) enhancer.create();
        return o;
    }
}