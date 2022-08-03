<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/8/1
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>

<head>
    <title>登录界面</title>
    <style>
        #frame_{
            width: 700px;
            height: 600px;
            margin-left: 30%;
            margin-top: 5%;
            background-color: azure;
            border: black solid 2px;
        }

        #inner_{
            margin-left: 235px;
            margin-top: 200px;
        }
    </style>
    <!--在这里写js代码对数据进行验证:
        用户id是否为空
        密码是否为空-->
</head>

<body>
    <div id="frame_">
        <div id="inner_">
            用户id:<input type="text" id="u_id"><br><br>
            密码:<input type="password" id="u_pwd"><br><br>
            <button id="btn01">重置</button>
            <button style="margin-left: 20px" id="btn02">登录</button><br><br>

            <span id="error" style="color: red">${error}</span>

            <script>
                let btn001 = document.getElementById("btn02")
                btn001.onclick = function (){
                    //1、获取id查看是否为空
                    let id_str = document.getElementById("u_id").value;
                    if (id_str == null||id_str == ""){
                        document.getElementById("error").innerHTML = "账户不能为空";
                        return;
                    }
                    //获取pwd查看是否为空
                    let pwd_str = document.getElementById("u_pwd").value;
                    if (pwd_str == null||pwd_str == ""){
                        document.getElementById("error").innerHTML = "密码不能为空";
                        return;
                    }
                    //验证完成后访问服务器
                    window.location.href = "login?u_id=" + id_str + "&" + "u_pwd=" + pwd_str;
                }
            </script>
        </div>
    </div>
</body>

</html>
