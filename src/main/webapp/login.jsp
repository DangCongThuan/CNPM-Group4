<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 5/20/2023
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="login.css">
</head>
<body>
<form action="" method="post">


    <div class="container">
        <label><b>Email</b></label>
        <input type="email" placeholder="Nhập email" name="uname" required>

        <label><b>Mật khẩu</b></label>
        <input type="password" placeholder="Nhập mật khẩu" name="psw" required>

        <button type="submit">Đăng nhập</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Nhớ tôi
        </label>
        <label>
            <span class="psw">Quên <a href="#">mật khẩu?</a></span>
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <span>Không có tài khoản <a href="#">đăng ký ngay?</a></span>
    </div>
</form>
</body>
</html>
