/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserServiceImpl
 * Author:   bmbbms
 * Date:     2019/6/3 8:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
/*
@Component(value="userService")	-- 相当于在XML的配置方式中 <bean id="userService" class="...">

	     Spring中提供@Component的三个衍生注解:(功能目前来讲是一致的)
		* @Controller		-- 作用在WEB层
		* @Service			-- 作用在业务层
		* @Repository		-- 作用在持久层
 */
@Component(value="userService")

public class UserServiceImpl implements  UserService{
    /**
     * * 如果是注入的普通类型，可以使用value注解
			* @Value			-- 用于注入普通类型
     */
    @Value("meimei")
    private String name;

    @Autowired
    private List<UserDao> e;

    /**
     * * @Resource				-- 相当于@Autowired和@Qualifier一起使用
			* 强调：Java提供的注解
			* 属性使用name属性

     */
    @Autowired
    @Qualifier("userdao")
    private UserDao userDao;

    @Override
    public void save() {
        System.out.println("我是业务层"+ name );
//        for(UserDao dao : e){
//            dao.save();
//        }

//        userDao.save();
    }
}