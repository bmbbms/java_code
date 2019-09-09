/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: TestDao
 * Author:   bmbbms
 * Date:     2019/6/11 15:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import dao.UserDao;
import dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/11
 * @since 1.0.0
 */
public class TestDao {
    private SqlSessionFactory sq;

    @Before
    public void setup() throws IOException {
    String resource = "SqlMapConfig.xml";

    InputStream is = Resources.getResourceAsStream(resource);
    sq = new SqlSessionFactoryBuilder().build(is);
    }


    @Test
    public void findById(){
        UserDao userDao = new UserDaoImpl(sq);
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void insertUser(){
        UserDao userDao = new UserDaoImpl(sq);
        User user = new User();

        user.setId(35);
        user.setUsername("fuck");
        user.setBirthday(new Date());

        userDao.insertUser(user);
        System.out.println(user);
    }
}
