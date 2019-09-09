/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserDao
 * Author:   bmbbms
 * Date:     2019/6/3 8:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package service;

import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/3
 * @since 1.0.0
 */
@Repository(value = "userdao")
public class UserDao {
    public void save(){
        System.out.println("我是持久层");
    }

}