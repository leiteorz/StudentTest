<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
    <style>
        #head_{
            height: 100px;
            width: 100%;
            background-color: slategray;
        }
        #personFile{
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }
        #search{
            height: 70px;
            width: 100%;
            background-color: cornflowerblue;
        }
        #inner_s{
            width: 30%;
            padding-top:25px;
            padding-left: 45%;
        }
        #table{
            margin-left: 30%;
            margin-top: 30px;
        }
        td{
            text-align: center;
            height: 20px;
            width: 150px;
            border: black 1px solid;
            padding:1px;
        }
        #warm_{
            margin-left: 750px;
        }
    </style>

    <script>
        function search(){
            //拿到要搜索的信息
            let v = document.getElementById("fileId").value;
            //v可能是id或者名字
            //访问服务器
            window.location.href = "mainServlet?search=" + v + "&u_id=${user.getU_id()}";
        }

        function del(v){
            window.location.href = "delServlet?del=" + v + "&u_id=${user.getU_id()}";
        }

        function update(v){
            window.location.href = "updateServlet?update=" + v + "&u_id=${user.getU_id()}";
        }
    </script>
</head>
<body>

<div id="head_">
    <div id="personFile">
        名字:<span style="color: blue">${user.getU_name()}</span><br>
        编号:<span style="color: blue">${user.getU_id()}</span>
    </div>
</div>

<div id="search">
    <div id="inner_s">
        <input type="text" style="font-size: 20px; height: 26px;width: 190px" id="fileId">&nbsp;&nbsp;
        <button  style="font-size: 18px; height: 28px;" onclick="search()">查询</button>

    </div>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr >
            <td>学生id</td>
            <td>学生名字</td>
            <td>学生电话</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${arrUser}" var="item">
            <tr>
                <td>${item.getU_id()}</td>
                <td>${item.getU_name()}</td>
                <td>${item.getU_phone()}</td>
                <td><button style="color: chocolate" onclick="update(${item.getU_id()})">修改</button>
                    <button style="color: chocolate" onclick="del(${item.getU_id()})">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div id="warm_"><span id="error" style="color: red">${error}</span></div>
</div>
<div>
</div>
</body>
</html>

