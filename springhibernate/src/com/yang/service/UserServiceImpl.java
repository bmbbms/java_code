/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserServiceImpl
 * Author:   bmbbms
 * Date:     2019/6/3 17:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yang.service;

import com.yang.dao.UserDao;
import com.yang.dao.UserDaoImpl;
import com.yang.domain.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
@Transactional
@Service("userservice")
public class UserServiceImpl implements UserService {
    @Resource(name = "userdao")
    private UserDao userdao;


    @Override
    public void save(Customer customer) {
        System.out.println("业务层");
        userdao.save(customer);

    }




}