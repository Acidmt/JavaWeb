<%@ page contentType="text/html ; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Tit1e$</title>
        <link rel="stylesheet" type="text/css" href="./resource/css/login.css"/>
    </head>
    <body>
        <form action="AddUserBase" method="post">
            <div class="loginmain">
                <div class="login-title">
                    <span>用户登录</span>
                </div>

                <div class="login-con">
                    <div class="login-user">
                        <div class="icon">
                            <img src="./resource/images/user_icon_copy.png" alt="">
                        </div>
                        <input type="text" name="name" placeholder="用户名" autocomplete="off" value="">
                    </div>
                    <div class="login-pwd">
                        <div class="icon">
                            <img src="./resource/images/lock_icon_copy.png" alt="">
                        </div>
                        <input type="password" name="password" placeholder="密码" autocomplete="off" value="">
                    </div>
                    <div class="login-yan">
                        <div class="icon">
                            <img src="./resource/images/key.png" alt="">
                        </div>
                        <input type="password" name="password2" placeholder="确认密码" autocomplete="off" value="">
                    </div>
                    <div class="login-yan">
                        <div class="icon">
                            <img src="./resource/images/key.png" alt="">
                        </div>
                        <input type="text" name="email" placeholder="邮箱" autocomplete="off" value="">
                    </div>
                    <div class="login-btn">
                        <input type="submit" value="注册">
                    </div>
                    <div class="login-btn" style="bottom:42px">
                        <input type="button" onclick='location.href=("Login.jsp")' value="返回">
                    </div>
                </div>

            </div>
        </form>

    </body>
</html>