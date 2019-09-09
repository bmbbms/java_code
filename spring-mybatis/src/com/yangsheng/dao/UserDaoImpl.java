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
package com.yangsheng.dao;

import com.yangsheng.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;


/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/11
 * @since 1.0.0
 */
public class UserDaoImpl  extends SqlSessionDaoSupport implements UserDao {


     @Override
     public User findById(Integer id) {


    SqlSession sqlSession = this.getSqlSession();

    User user = sqlSession.selectOne("test.findUserById", id);

    return  user;

}

    @Override
    public void insertUser(User user) {

    SqlSession sqlSession = this.getSqlSession();

    sqlSession.insert("test.insertUser", user);

    sqlSession.commit();

    }
}