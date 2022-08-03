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

@WebServlet("/sureUpdate")
public class sureUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿到前端服务器传来的信息
        String stu_name = req.getParameter("stu_name"); //修改后的学生姓名
        String stu_phone = req.getParameter("stu_phone");   //修改后的学生电话
        String stu_id = req.getParameter("stu_id"); //被修改的学生ID
        String admin_id = req.getParameter("u_id"); //登录的账号

        FileService fs = new FileServiceImpl();
        User admin = fs.selectById(Integer.parseInt(admin_id));
        req.setAttribute("user",admin);

        fs.updateById(stu_name,stu_phone,Integer.parseInt(stu_id));

        List<User> allStudent = fs.getAllStudent();
        req.setAttribute("arrUser",allStudent);

        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
    }
}
