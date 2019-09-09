/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: TestMybatis
 * Author:   bmbbms
 * Date:     2019/6/11 13:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.User;


import java.io.IOException;
import java.io.InputStream;
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
public class TestMybatis {
@Test
    public void testFindById() throws IOException {
    String resource = "SqlMapConfig.xml";

    InputStream is = Resources.getResourceAsStream(resource);
    SqlSessionFactory sq = new SqlSessionFactoryBuilder().build(is);

    SqlSession sqlSession = sq.openSession();

    User user = sqlSession.selectOne("test.findUserById", 1);
    System.out.println(user);

}

    @Test
    public void testFindByUserName() throws IOException {
    String resource = "SqlMapConfig.xml";

    InputStream is = Resources.getResourceAsStream(resource);
    SqlSessionFactory sq = new SqlSessionFactoryBuilder().build(is);

    SqlSession sqlSession = sq.openSession();

    List <User> user = sqlSession.selectList("test.findUserByUsername", "王");
    System.out.println(user);

}



    @Test
    public void InsertUser() throws IOException {
    String resource = "SqlMapConfig.xml";

    InputStream is = Resources.getResourceAsStream(resource);
    SqlSessionFactory sq = new SqlSessionFactoryBuilder().build(is);

    SqlSession sqlSession = sq.openSession();
        User user = new User();


        user.setUsername("张小明");
        user.setAddress("河南郑州");
        user.setSex("1");
        user.setBirthday(new Date());

        int insert = sqlSession.insert("test.insertUser", user);
        System.out.println(user.getId());
        sqlSession.commit();

}


    @Test
    public void DeleteUserById() throws IOException {
    String resource = "SqlMapConfig.xml";

    InputStream is = Resources.getResourceAsStream(resource);
    SqlSessionFactory sq = new SqlSessionFactoryBuilder().build(is);

    SqlSession sqlSession = sq.openSession();

    sqlSession.delete("test.deleteUserById",29);

    sqlSession.commit();

}


    @Test
    public void UpdateUser() throws IOException {
    String resource = "SqlMapConfig.xml";

    InputStream is = Resources.getResourceAsStream(resource);
    SqlSessionFactory sq = new SqlSessionFactoryBuilder().build(is);

    SqlSession sqlSession = sq.openSession();

        User user = new User();

        user.setUsername("ys");
        user.setId(30);

        sqlSession.update("test.updateUser",user);

    sqlSession.commit();

}
}