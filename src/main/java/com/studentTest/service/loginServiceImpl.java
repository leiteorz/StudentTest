package com.studentTest.service;

import com.studentTest.bean.User;
import com.studentTest.dao.loginDao;
import com.studentTest.dao.loginDaoImpl;

public class loginServiceImpl implements loginService{
    @Override
    public User loginService(User user) {
        loginDao ld = new loginDaoImpl();
        return ld.loginDao(user);
    }
}
