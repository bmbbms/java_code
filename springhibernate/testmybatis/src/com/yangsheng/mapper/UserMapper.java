/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserMapper
 * Author:   bmbbms
 * Date:     2019/6/12 11:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.mapper;

import com.yangsheng.pojo.Orders;
import com.yangsheng.pojo.User;

import java.util.List;

/**
 * 〈一句话功能简述〉<br/>
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/12
 * @since 1.0.0
 */
public interface UserMapper {
    User findById(Integer id);

    List <User> findByUsernameAndSex(User user);
    List<User> findByIds(List<Integer> ids);
    List<Orders> findOrdersandUser();
}