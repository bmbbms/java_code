/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: MyAspectXml
 * Author:   bmbbms
 * Date:     2019/6/3 11:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */

@Component("myAspectAnno")
@Aspect
public class MyAspectAnno {
    @Around(value = "execution(public  * service.UserDao.save())")
    public void log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("anno1");

        proceedingJoinPoint.proceed();

        System.out.println("anno2");
    }
}