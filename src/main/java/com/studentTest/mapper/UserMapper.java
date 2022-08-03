package com.studentTest.mapper;

import com.studentTest.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //查询所有学生信息
    List<User> selectAllStudent();
    //根据id查询
    User selectById(int u_id);
    //修改
    void updateById(@Param("u_name")String u_name,@Param("u_phone")String u_phone,@Param("u_id")int u_id);
    //删除
    void deleteById(int u_id);
}
