/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserMapper
 * Author:   bmbbms
 * Date:     2019/6/11 15:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package mapper;

import pojo.User;

import java.util.List;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/11
 * @since 1.0.0
 */
public interface UserMapper {
    User findUserById(int id);
    void insertUser(User user);
    List<User> findByUsernameAndSex(User user);
    List<User>  findByIds (List<Integer> ids);

}