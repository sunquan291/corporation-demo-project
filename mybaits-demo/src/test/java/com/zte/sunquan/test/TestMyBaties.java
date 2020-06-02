package com.zte.sunquan.test;

import com.zte.sunquan.bean.User;
import com.zte.sunquan.dao.UserDao;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBaties extends TestCase {

    @Before
    public void init() {

    }

    /**
     * 共6步操作完成CRUD
     *
     * @throws IOException
     */
    public void testBatis() throws IOException {
        // 指定MyBatis配置文件
        String RESOURCE = "./mybatis-config.xml";
        // 1、指定MyBaties配置文件
        InputStream inputstream = Resources.getResourceAsStream(RESOURCE);
        // 2、创建SqlSessionFactory()
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
        SqlSession session = null;
        try {
            // 3、获取SqlSession
            session = sessionFactory.openSession();
            // 4、获取DAO接口对象
            UserDao mapper = session.getMapper(UserDao.class);
            // 5、CRUD操作
            // 5.1--添加影片
            User user = new User();
            //user.setId(1L);
            user.setAge(28);
            user.setName("sunquan");
            mapper.addUser(user);
            session.commit();
            List<User> allUser = mapper.getAllUser();
            allUser.forEach(System.out::println);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6、关闭SqlSession
            if (session != null) {
                session.close();
            }
        }
    }
}