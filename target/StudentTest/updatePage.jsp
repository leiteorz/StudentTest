<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/8/3
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>修改界面</title>
    <style>
        #inner_{
            width: 700px;
            height: 600px;
            margin-left: 30%;
            margin-top: 5%;
            background-color: azure;
            border: black solid 2px;
        }
    </style>

    <script>
        //确认修改
        function updateSure(){
            let stu_name = document.getElementById("stu_name").value;
            let stu_phone = document.getElementById("stu_phone").value;
            //访问服务器
            window.location.href = "sureUpdate?stu_name=" + stu_name + "&stu_phone=" + stu_phone + "&stu_id=${stuId}" +"&u_id=${admin.getU_id()}";
        }
        //回到主界面
        function backToMain(){
            window.location.href = "backToMain?u_id=${admin.getU_id()}";
        }
    </script>
</head>
<body>
    <div id="inner_">
        <div style="font-size: 40px;margin-top: 40px;margin-left: 220px">成绩修改界面</div>
        <div style="margin-left: 220px;margin-top: 80px">
            <span>学生姓名:&nbsp;${stuName}</span><br><br>
            <span>学生id:&nbsp;${stuId}</span><br><br>
            姓名:&nbsp;&nbsp;<input type="text" id="stu_name"><br><br>
            电话号码:&nbsp;&nbsp;<input type="text" id="stu_phone"><br><br>
            <button onclick="backToMain()">返回主界面</button>&nbsp;&nbsp;
            <button onclick="updateSure()">确认修改</button>
        </div>
    </div>
</body>
</html>
