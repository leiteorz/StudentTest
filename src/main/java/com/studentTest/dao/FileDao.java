package com.studentTest.dao;

import com.studentTest.bean.User;
import java.util.List;

public interface FileDao {
    List<User> getAllStudent();

    User selectById(int u_id);

    void deleteById(int u_id);

    void updateById(String u_name, String u_phone, int u_id);
}
