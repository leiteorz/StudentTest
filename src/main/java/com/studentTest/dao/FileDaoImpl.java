package com.studentTest.dao;

import com.studentTest.bean.User;
import com.studentTest.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileDaoImpl implements FileDao{
    @Override
    public List<User> getAllStudent() {
        //加载数据库中所有学生
        //加载mybatis核心配置文件
        String resourse = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resourse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，让他来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> arrUser = userMapper.selectAllStudent();
        //释放资源
        sqlSession.close();

        return arrUser;
    }

    @Override
    public User selectById(int u_id) {
        //加载数据库中所有学生
        //加载mybatis核心配置文件
        String resourse = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resourse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，让他来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(u_id);
        //释放资源
        sqlSession.close();

        return user;
    }

    @Override
    public void deleteById(int u_id) {
        //加载数据库中所有学生
        //加载mybatis核心配置文件
        String resourse = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resourse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，让他来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //删除
        userMapper.deleteById(u_id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public void updateById(String u_name, String u_phone, int u_id) {
        //加载数据库中所有学生
        //加载mybatis核心配置文件
        String resourse = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resourse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession对象，让他来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //修改
        userMapper.updateById(u_name,u_phone,u_id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
