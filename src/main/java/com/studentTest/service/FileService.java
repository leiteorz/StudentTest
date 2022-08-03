package com.studentTest.service;

import com.studentTest.bean.User;

import java.util.List;

public interface FileService {
    List<User> getAllStudent();

    User selectById(int u_id);

    void deleteById(int u_id);

    void updateById(String u_name,String u_phone,int u_id);
}
