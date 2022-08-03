package com.studentTest.servlet;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;
import com.studentTest.service.loginService;
import com.studentTest.service.loginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取登录界面传输过来的信息
        String u_id = req.getParameter("u_id");
        String u_pwd = req.getParameter("u_pwd");

        User u = new User();
        u.setU_id(Integer.parseInt(u_id));
        u.setU_pwd(u_pwd);

        //实现登录服务器的业务逻辑层
        loginService l = new loginServiceImpl();
        User user = l.loginService(u);
        //账户密码匹配，跳转主界面
        if (user != null){
            //加载数据库中所有学生信息
            FileService fileService = new FileServiceImpl();
            List<User> arrUser = fileService.getAllStudent();

            req.setAttribute("user",user);
            req.setAttribute("arrUser",arrUser);
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        }
        //如果不匹配，跳转到登录界面
        else {
            req.setAttribute("error","账号或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }
}
