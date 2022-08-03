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

@WebServlet("/backToMain")
public class backToMainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admin_id = req.getParameter("u_id");
        FileService fs = new FileServiceImpl();

        User admin = fs.selectById(Integer.parseInt(admin_id));
        List<User> allStudent = fs.getAllStudent();

        req.setAttribute("user",admin);
        req.setAttribute("arrUser",allStudent);

        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
    }
}
