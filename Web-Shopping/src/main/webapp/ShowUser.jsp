<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>ShowUser</title>
        <link rel="stylesheet" type="text/css" href="./resource/css/login.css"/>
    </head>
    <body>
    <center>
        <table border="4px" style="text-align: center; margin-top:30px; color: #fff; background: rgba(148,121,149,0.7)" height="600px" width="1000px" align="center" >
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>密码</td>
            <td>email</td>
        </tr>
            <c:forEach var="findUser" items="${findUser}">
                <tr>
                    <td>${findUser.id}</td>
                    <td>${findUser.username}</td>
                    <td>${findUser.password}</td>
                    <td>${findUser.email}</td>
                </tr>
            </c:forEach>

        </table>
        </center>
    </body>
</html>