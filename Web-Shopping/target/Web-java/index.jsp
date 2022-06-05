<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
       <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <meta http-equiv="X-UA-Compatible" content="ie=edge">
       <title>Shopping</title>
       <link rel="stylesheet" type="text/css" href="./resource/css/sidebar.css"/>
    </head>
    <body>
    <div id="wrapper" style="left:0;">
        <div class="sidebar">
            <div class="headSculpture">
                <img src="./resource/images/heard.jpg" alt="">
                 <c:choose>
                    <c:when test="${userName!=null}">
                        <div>
                            <p>你好：${userName}</p>
                        </div>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="option">
                <ul>
                <c:if test="${userName==null}">
                    <li>
                        <img src="./resource/images/home.png" alt="">
                        <a href="Login.jsp"><p>登录</p></a>
                    </li>
                </c:if>
                <c:if test="${userName!=null}">
                    <li><img src="./resource/images/release.png" alt="">
                        <a href="/Web-Shopping/RemoveUser"><p>注销</p></a>

                </c:if>
                    <li><img src="./resource/images/home.png" alt="">
                        <p>首页</p>
                    </li>

                    <li><img src="./resource/images/collection.png" alt="">
                        <a href="/Web-Shopping/CartShopping"><p>我的收藏</p></a>
                    </li>
                    <li><img src="./resource/images/setup.png" alt="">
                        <a href="https://boringavatars.com"><p>设置</p></a>
                    </li>
                    <div class="partition"></div>
                    <c:set var="userTime" value="${userName}Time" scope="page"/>
                    <c:choose>
                        <c:when test="${cookie[userTime].value!=null&&userName!=null}">
                            <li><span>上次访问时间:<br>${cookie[userTime].value}</span></li>
                            </li>
                            <li><a href="SelectUser">点击查看所有用户信息</a></li>
                            <li>
                                <form action="SelectUser" method="post">
                                    <input type="text" placeholder="搜索已注册的用户信息" name="userName">
                                    <input type="submit" value="搜索"/>
                                </form>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${userName!=null}">
                                <li><span>您是第一次访问</span></li>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>

        </div>
        <button></button>
        <!-- 内容区域 -->
        <div class="banner">
            <center><h4><a href="/Web-Shopping/CartShopping" style="color:#fff">我的购物车</a></h4></center>
        </div>
         <c:if test="${empty list}">
            <jsp:forward page="/OpearBase"></jsp:forward>
        </c:if>
        <table border="4px" style="text-align: center;" height="520px" width="1000px" align="center">
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
    </div>
    <script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="./resource/js/sidebar.js"></script>
    </body>
</html>