/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserDao
 * Author:   bmbbms
 * Date:     2019/6/11 15:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.dao;


import com.yangsheng.pojo.User;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/11
 * @since 1.0.0
 */
public interface UserDao {
 User findById(Integer id);
 void insertUser(User user);
}