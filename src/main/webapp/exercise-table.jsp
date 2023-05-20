<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 5/20/2023
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="exercise-table.css">
    <link rel="stylesheet" href="style.css">
    <script>
        $(document).ready(function(){
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
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
<div class="container">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-xs-6">
                        <h2>Bảng <b>Hoạt Động</b></h2>
                    </div>
                    <div class="col-xs-6">
                        <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm hoạt động</span></a>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Tên</th>
                    <th>Lượng calo</th>
                    <th>Ngày</th>
                    <th>Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${listEx}">

                <tr>
                    <td>${i.name}</td>
                    <td>${i.totalCalorie}</td>
                    <td>${i.exDate}</td>
                    <td>
                        <a href="<c:url value="/edit-exercise?exId=${i.id}"/>" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                        <a href="<c:url value="/delete-exercise?exId=${i.id}"/>" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="<c:url value="/add-exercise"/>" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm hoạt động</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên</label>
                        <input type="text" name="exercise-name" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Lượng calo</label>
                        <input type="number" name="total-calorie" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Thời lượng (giờ)</label>
                        <input type="number" name="duration" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Ngày</label>
                        <input type="datetime-local" name="ex-date" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                    <input type="submit" class="btn btn-success" value="Thêm">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Chỉnh sửa hoạt động</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên</label>
                        <input type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Lượng calo</label>
                        <input type="number" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Thời lượng (giờ)</label>
                        <input type="number" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Ngày</label>
                        <input type="datetime-local" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                    <input type="submit" class="btn btn-info" value="Lưu">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Xóa hoạt động</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Bạn có chắc muốn xóa hoạt động này?</p>
                    <p class="text-warning"><small>Hành động này không thể hoàn tác.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                    <input type="submit" class="btn btn-danger" value="Xóa">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>