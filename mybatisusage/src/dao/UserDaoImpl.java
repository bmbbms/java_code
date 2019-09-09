/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: UserDaoImpl
 * Author:   bmbbms
 * Date:     2019/6/11 15:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/11
 * @since 1.0.0
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }



     @Override
     public User findById(Integer id) {


    SqlSession sqlSession = sqlSessionFactory.openSession();

    User user = sqlSession.selectOne("test.findUserById", id);

    return  user;

}

    @Override
    public void insertUser(User user) {

    SqlSession sqlSession = sqlSessionFactory.openSession();

    sqlSession.insert("test.insertUser", user);

    sqlSession.commit();

    }
}