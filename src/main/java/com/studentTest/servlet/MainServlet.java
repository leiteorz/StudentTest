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
import java.util.Collections;
import java.util.List;

@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String v = req.getParameter("search");

        FileService fs2 = new FileServiceImpl();
        //获取登录的那个人的信息
        String id = req.getParameter("u_id");
        User admin = fs2.selectById(Integer.parseInt(id));
        req.setAttribute("user",admin);
        //获取所有学生信息
        List<User> allStudents = fs2.getAllStudent();

        if (v != ""){
            FileService fs = new FileServiceImpl();
            User user = fs.selectById(Integer.parseInt(v));  //查询
            List<User> arrUser = Collections.singletonList(user);
            //如果能查询到
            if (user != null){
                req.setAttribute("arrUser",arrUser);
                req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
            }
            //没有查找到
            else {
                req.setAttribute("arrUser",allStudents);
                req.setAttribute("error","没有该学生");
                req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("arrUser",allStudents);
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        }
    }
}
