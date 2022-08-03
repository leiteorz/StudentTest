package com.studentTest.servlet;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/delServlet")
public class DeleteServlet extends HttpServlet {
    //前端传过来管理员和要删除的人的信息
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //登录过来的那个人的信息
        FileService fs = new FileServiceImpl();
        String u_id = req.getParameter("u_id");
        User admin = fs.selectById(Integer.parseInt(u_id));
        req.setAttribute("user",admin);
        //获取所有学生信息
        List<User> allStudent = fs.getAllStudent();
        req.setAttribute("arrUser",allStudent);
        //要删除的那个人的信息
        String stu_id = req.getParameter("del");
        fs.deleteById(Integer.parseInt(stu_id));
        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
    }
}
