/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: TestMapper
 * Author:   bmbbms
 * Date:     2019/6/11 15:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import dao.UserDao;
import dao.UserDaoImpl;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/6/11
 * @since 1.0.0
 */
public class TestMapper {
    private SqlSessionFactory sq;

    @Before
    public void setup() throws IOException {
    String resource = "SqlMapConfig.xml";

    InputStream is = Resources.getResourceAsStream(resource);
    sq = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void findById(){
        SqlSession sqlSession = sq.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);

        System.out.println(user);
    }

      @Test
public void insertUser(){
        SqlSession sqlSession = sq.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(35);
        user.setUsername("fuck");
        user.setBirthday(new Date());

        mapper.insertUser(user);
        System.out.println(user);
        sqlSession.commit();
    }
    
        @Test
        public void findbyusernameAndsex(){
        SqlSession sqlSession = sq.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
//        user.setSex("1");
//        user.setUsername("王");

        List <User> list = mapper.findByUsernameAndSex(user);
        System.out.println(list);
        sqlSession.commit();
    }

         @Test
        public void findByIds(){
        SqlSession sqlSession = sq.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
             List <Integer> ids = new ArrayList <>();
             ids.add(1);
             ids.add(32);
             ids.add(30);

             List <User> userList = mapper.findByIds(ids);
             System.out.println(userList);
             sqlSession.commit();
    }
}