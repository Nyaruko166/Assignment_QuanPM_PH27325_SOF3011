<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/24/2023
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<html>
<head>
    <title>KhachHang</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form action="/khach-hang/add" method="post" class="container">
    <div class="mb-2">
        <label for="id" class="form-label">ID</label>
        <input type="text" class="form-control" id="id" name="id" disabled>
    </div>
    <div class="mb-2">
        <label for="ma" class="form-label">Mã</label>
        <input type="text" class="form-control" id="ma" name="ma">
    </div>
    <div class="mb-2">
        <label for="ten" class="form-label">Tên</label>
        <input type="text" class="form-control" id="ten" name="ten">
    </div>
    <div class="mb-2">
        <label for="tenDem" class="form-label">Tên Đệm</label>
        <input type="text" class="form-control" id="tenDem" name="tenDem">
    </div>
    <div class="mb-2">
        <label for="ho" class="form-label">Họ</label>
        <input type="text" class="form-control" id="ho" name="ho">
    </div>
    <div class="mb-2">
        <label for="ngaySinh" class="form-label">Ngày Sinh</label>
        <input type="date" class="form-control" id="ngaySinh" name="ngaySinh">
    </div>
    <div class="mb-2">
        <label for="sdt" class="form-label">SDT</label>
        <input type="text" class="form-control" id="sdt" name="sdt">
    </div>
    <div class="mb-2">
        <label for="diaChi" class="form-label">Địa Chỉ</label>
        <input type="text" class="form-control" id="diaChi" name="diaChi">
    </div>
    <div class="mb-2">
        <label for="thanhPho" class="form-label">Thành Phố</label>
        <input type="text" class="form-control" id="thanhPho" name="thanhPho">
    </div>
    <div class="mb-2">
        <label for="quocGia" class="form-label">Quốc Gia</label>
        <input type="text" class="form-control" id="quocGia" name="quocGia">
    </div>
    <div class="mb-2">
        <label for="matKhau" class="form-label">Mật Khẩu</label>
        <input type="password" class="form-control" id="matKhau" name="matKhau">
    </div>
    <button type="submit" class="btn btn-success">Thêm</button>
</form>
<table class="table">
    <thead>
    <tr>
        <td>Id</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Tên Đệm</td>
        <td>Họ</td>
        <td>Ngày Sinh</td>
        <td>SDT</td>
        <td>Địa Chỉ</td>
        <td>Thành Phố</td>
        <td>Quốc Gia</td>
        <td>Mật Khẩu</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKhachHang}" var="kh">
        <tr>
            <td>${kh.id}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>${kh.matKhau}</td>
            <td><a href="/khach-hang/detail?id=${kh.id}" class="btn btn-success">Detail</a>
                <a href="/khach-hang/delete?id=${kh.id}" class="btn btn-danger">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
