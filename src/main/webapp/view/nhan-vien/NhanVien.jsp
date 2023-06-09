<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2023
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet"
          type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
          rel="stylesheet" type="text/css"/>
    <link href="/css/css.css" rel="stylesheet"/>
</head>
<body>

<%@include file="/view/layout/header.jsp" %>

<form action="/nhan-vien/add" method="post" class="container">
    <h2 class="title">Thông Tin Nhân Viên</h2>
    <%--    <div class="mb-2">--%>
    <%--        <label for="id" class="form-label">ID</label>--%>
    <%--        <input type="text" class="form-control" id="id" name="id" disabled>--%>
    <%--    </div>--%>
    <div class="row">
        <div class="col-6">
            <label for="ma" class="form-label">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma">
        </div>
        <div class="col-6">
            <label for="ten" class="form-label">Tên</label>
            <input type="text" class="form-control" id="ten" name="ten">
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label for="tenDem" class="form-label">Tên Đệm</label>
            <input type="text" class="form-control" id="tenDem" name="tenDem">
        </div>
        <div class="col-6">
            <label for="ho" class="form-label">Họ</label>
            <input type="text" class="form-control" id="ho" name="ho">
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label for="ngaySinh" class="form-label">Ngày Sinh</label>
            <input type="date" class="form-control" id="ngaySinh" name="ngaySinh">
        </div>
        <div class="col-6">
            <label for="diaChi" class="form-label">Địa Chỉ</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi">
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label for="sdt" class="form-label">SĐT</label>
            <input type="number" class="form-control" id="sdt" name="sdt">
        </div>
        <div class="col-6">
            <label for="matKhau" class="form-label">Mật Khẩu</label>
            <input type="text" class="form-control" id="matKhau" name="matKhau">
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label for="cuaHang" class="form-label">Cửa Hàng</label>
            <select name="cuaHang" id="cuaHang" class="form-select" aria-label="Default select example">
                <%--        <option selected>Open this select menu</option>--%>
                <c:forEach items="${lstCH}" var="ch">
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>

            </select>
        </div>
        <div class="col-6">
            <label for="chucVu" class="form-label">Chức Vụ</label>
            <select name="chucVu" id="chucVu" class="form-select" aria-label="Default select example">
                <%--        <option selected>Open this select menu</option>--%>
                <c:forEach items="${lstCV}" var="cv">
                    <option value="${cv.id}">${cv.ten}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label class="form-label">Trạng Thái</label>
            <div class="form-check">
                <input value="1" class="form-check-input" type="radio" name="trangThai" id="trangThai1" checked>
                <label class="form-check-label" for="trangThai1">
                    Hoạt Động
                </label>
            </div>
            <div class="form-check">
                <input value="0" class="form-check-input" type="radio" name="trangThai" id="trangThai2">
                <label class="form-check-label" for="trangThai2">
                    Ngừng Hoạt Động
                </label>
            </div>
        </div>
        <div class="col-6">
            <label class="form-label">Giới Tính</label>
            <div class="form-check">
                <input value="Nam" class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1" checked>
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input value="Nữ" class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2">
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>
        </div>
    </div>
    <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-success">Thêm</button>
    </div>
</form>
<section style="text-align: center">
    <table class="table table-striped table-hover">
        <thead>
        <tr class="table_title">
            <td>Id</td>
            <td>Mã</td>
            <td>Tên</td>
            <td>Tên Đệm</td>
            <td>Họ</td>
            <td>Giới Tính</td>
            <td>Ngày Sinh</td>
            <td>Địa Chỉ</td>
            <td>SĐT</td>
            <td>Mật Khẩu</td>
            <td>Cửa Hàng</td>
            <td>Chức Vụ</td>
            <td>Id BC</td>
            <td>Trạng Thái</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lstNV}" var="x">
            <tr>
                <td>${x.id}</td>
                <td>${x.ma}</td>
                <td>${x.ten}</td>
                <td>${x.tenDem}</td>
                <td>${x.ho}</td>
                <td>${x.gioiTinh}</td>
                <td>${x.ngaySinh}</td>
                <td>${x.diaChi}</td>
                <td>${x.sdt}</td>
                <td>${x.matKhau}</td>
                <td>${x.cuaHang.ten}</td>
                <td>${x.chucVu.ten}</td>
                <td>${x.idGuiBC}</td>
                <c:if test="${x.trangThai == 0}">
                    <td>Ngừng Hoạt Động</td>
                </c:if>
                <c:if test="${x.trangThai != 0}">
                    <td>Hoạt Động</td>
                </c:if>
                <td><a href="/nhan-vien/detail?id=${x.id}" class="btn btn-success">Detail</a>
                    <a href="/nhan-vien/delete?id=${x.id}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<%@include file="/view/layout/footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>
