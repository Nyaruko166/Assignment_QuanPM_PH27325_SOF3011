<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/27/2023
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>

<form action="/khach-hang/update" method="post" class="container">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">ID</label>
        <div class="col-sm-10">
            <input value="${khachHang.id}" class="form-control" type="text" name="id" disabled><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input value="${khachHang.ma}" class="form-control" type="text" name="ma"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input value="${khachHang.ten}" class="form-control" type="text" name="ten"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên Đệm</label>
        <div class="col-sm-10">
            <input value="${khachHang.tenDem}" class="form-control" type="text" name="tenDem"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Họ</label>
        <div class="col-sm-10">
            <input value="${khachHang.ho}" class="form-control" type="text" name="ho"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ngày Sinh</label>
        <div class="col-sm-10">
            <input value="${ngaySinh}" class="form-control" type="date" name="ngaySinh"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">SĐT</label>
        <div class="col-sm-10">
            <input value="${khachHang.sdt}" class="form-control" type="text" name="sdt"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Địa Chỉ</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="diaChi" value="${khachHang.diaChi}"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Thành Phố</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="thanhPho" value="${khachHang.thanhPho}"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Quốc Gia</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="quocGia" value="${khachHang.quocGia}"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mật Khẩu</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="matKhau" value="${khachHang.matKhau}"><br>
        </div>
    </div>
    <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-success">Sửa</button>
    </div>
</form>
</body>
</html>
