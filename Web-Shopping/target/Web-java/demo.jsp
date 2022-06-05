<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>$Tit1e$</title>
    </head>
    <body>
        <div>
        <h2>主页</h2>
        <c:choose>
            <c:when test="${userName!=null}">
                <div>
                    <span>你好：${userName}</span>
                    <a href="/Web-Shopping/RemoveUser">注销</a>
                    <c:set var="userTime" value="${userName}Time" scope="page"/>
                    <c:choose>
                        <c:when test="${cookie[userTime].value!=null}">
                            <span>上次访问时间：${cookie[userTime].value}</span>
                        </c:when>
                        <c:otherwise>
                            <span>您是第一次访问</span>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:when>
            <c:otherwise>
                <a href="Login.jsp">登录</a>
            </c:otherwise>
        </c:choose>
        </div>
        <form action="SelectUser" method="post">
            <input type="text" placeholder="搜索已注册的用户信息" name="userName">
            <input type="submit" value="搜索"/>
        </form>
        <a href="SelectUser">点击查看所有用户信息</a>
        <center>
            <h1>
                <a href="/Web-Shopping/CartShopping">我的购物车</a>
            </h1>
        </center>
         <c:if test="${empty list}">
            <jsp:forward page="/OpearBase"></jsp:forward>
        </c:if>
        <table border="10px" style="text-align: center;" height="600px" width="1000px" align="center" >
            <tr>
                <td>商品序号</td>
                <td>商品名称</td>
                <td>商品单价</td>
                <td>数量</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${list}" var="list">
                <tr style="font-size:20px;">
                    <td >${list.id}</td>
                    <td >${list.tradenme}</td>
                    <td >${list.price}</td>
                    <td >${list.number}</td>
                    <td >
                        <!-- 加入购物车 -->
                        <a href="/Web-Shopping/AddShoppong?cartid=${list.id}">
                            加入购物车
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>