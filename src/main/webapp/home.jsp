<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 5/20/2023
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Đăng nhập</title>
  <meta charset="UTF-8">
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
<main>
  <section>
    <h2>Gợi ý dinh dưỡng</h2>
    <p>Bạn nên ăn thêm rau xanh và trái cây để cung cấp đủ vitamin và khoáng chất cho cơ thể.</p>
    <button>Thực đơn gợi ý</button>
  </section>
  <section>
    <h2>Hoạt động trong ngày</h2>
    <p>Xem, cập nhật các hoạt động đã thực hiện trong ngày.</p>
    <button><a href="<c:url value="/table-exercise"/>">Xem ngay</a></button>
  </section>
</main>
<footer>
</footer>
</body>
</html>
