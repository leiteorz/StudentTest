package com.studentTest.service;

import com.studentTest.bean.User;
import com.studentTest.dao.FileDao;
import com.studentTest.dao.FileDaoImpl;

import java.util.List;

public class FileServiceImpl implements FileService{
    //访问持久层
    @Override
    public List<User> getAllStudent() {
        FileDao fileDao = new FileDaoImpl();
        return fileDao.getAllStudent();
    }

    @Override
    public User selectById(int u_id) {
        FileDao fileDao = new FileDaoImpl();
        return fileDao.selectById(u_id);
    }

    @Override
    public void deleteById(int u_id) {
        FileDao fileDao = new FileDaoImpl();
        fileDao.deleteById(u_id);
    }

    @Override
    public void updateById(String u_name, String u_phone, int u_id) {
        FileDao fileDao = new FileDaoImpl();
        fileDao.updateById(u_name,u_phone,u_id);
    }
}
