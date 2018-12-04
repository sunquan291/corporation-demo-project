package com.zte.sunquan.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zte.sunquan.bean.User;
import com.zte.sunquan.dao.UserDao;

public class TestMyBaties extends TestCase {

    /**
     * 共6步操作完成CRUD
     *
     * @throws IOException
     */
    public void testBaties() throws IOException {

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
            user.setAge(28);
            user.setName("sunquan");
//            mapper.addUser(user);
            List<User> allUser = mapper.getAllUser();
            allUser.forEach(System.out::println);
            session.commit();// 添加、修改、删除操作最后需要提交事务


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