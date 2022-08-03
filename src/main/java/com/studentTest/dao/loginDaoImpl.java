package com.studentTest.dao;

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

public class loginDaoImpl implements loginDao{
    @Override
    public User loginDao(User u) {
        //拿到登录传进来的账户密码
        int id = u.getU_id();
        String pwd = u.getU_pwd();
        //获取连接对象
        //加载mybatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAllStudent();
        //遍历循环查找是否匹配
        User user = new User();
        for (Iterator<User> it = users.iterator(); it.hasNext();) {
            user = it.next();
            if (user.getU_id() == id && user.getU_pwd().equals(pwd)){
                return user;
            }
        }
        return null;
    }
}
