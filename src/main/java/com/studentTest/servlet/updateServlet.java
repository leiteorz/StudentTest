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

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //登录过来的那个人的信息
        FileService fs = new FileServiceImpl();
        String u_id = req.getParameter("u_id");
        User admin = fs.selectById(Integer.parseInt(u_id));
        //获取要修改的人的id
        String stu_id = req.getParameter("update");
        User student = fs.selectById(Integer.parseInt(stu_id));
        String stu_name = student.getU_name();
        req.setAttribute("stuName",stu_name);
        //跳转到修改界面
        req.setAttribute("admin",admin);
        req.setAttribute("stuId",stu_id);

        req.getRequestDispatcher("updatePage.jsp").forward(req,resp);
    }
}
