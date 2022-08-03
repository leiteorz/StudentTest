package com.studentTest.util;

import com.studentTest.bean.User;
import com.studentTest.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        //加载mybatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAllStudent();

        User user = new User();

        for (Iterator<User> it = users.iterator(); it.hasNext();) {
            user = it.next();
            System.out.println(user.getU_id() + " " + user.getU_pwd());
        }
        //释放资源
        sqlSession.close();
    }
}
