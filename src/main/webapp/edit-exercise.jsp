<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 5/20/2023
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="login.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Phần mềm theo dõi dinh dưỡng</h1>
    <nav>
        <ul>
            <li><a href="#">Trang chủ</a></li>
            <li><a href="#">Thống kê</a></li>
            <li><a href="#">Cài đặt</a></li>
            <li><a href="#">Đăng xuất</a></li>
        </ul>
    </nav>
</header>
<form class="edit-exercise-form" action="<c:url value="/edit-exercise"/>" method="post">
<div class="container">
    <h1>Chỉnh sửa hoạt động</h1>
    <br>
    <p class="mess-error">${mess}</p>
    <label>ID</label>
    <input type="text" value="${ex.id}" name="idEx" readonly>

    <label>Tên hoạt động</label>
    <input type="text" value="${ex.name}" name="exercise-name" required>

    <label>Lượng calo</label>
    <input type="number" name="total-calorie" value="${ex.totalCalorie}" required>
    <label>Thời lượng (giờ)</label>
    <input type="number" name="duration" value="${ex.duration}" required>
    <label>Ngày</label>
    <input type="datetime-local" name="ex-date" value="${ex.exDate}" required>
    <div class="btn-section">
        <button class="cancelbtn"><a href="<c:url value="/table-exercise"/>">Hủy</a></button>
        <button class="submitbtn"  type="submit">Lưu</button>
    </div>
</div>
</form>
</body>
</html>
