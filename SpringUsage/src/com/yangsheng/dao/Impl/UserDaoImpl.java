/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserDaoImpl
 * Author:   bmbbms
 * Date:     2019/5/30 8:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.dao.Impl;

import com.yangsheng.dao.UserDao;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/30
 * @since 1.0.0
 */
public class UserDaoImpl  implements UserDao{

    @Override
    public void save() {
        System.out.println("持久层");
    }
}