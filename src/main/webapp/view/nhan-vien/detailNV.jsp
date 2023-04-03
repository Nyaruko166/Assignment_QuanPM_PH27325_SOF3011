<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2023
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Thông tin nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form action="/nhan-vien/update" method="post" class="container">
    <div class="mb-2">
        <label for="id" class="form-label">ID</label>
        <input type="text" class="form-control" id="id" name="id" disabled value="${nv.id}">
    </div>
    <div class="mb-2">
        <label for="ma" class="form-label">Mã</label>
        <input type="text" class="form-control" id="ma" name="ma" value="${nv.ma}">
    </div>
    <div class="mb-2">
        <label for="ten" class="form-label">Tên</label>
        <input type="text" class="form-control" id="ten" name="ten" value="${nv.ten}">
    </div>
    <div class="mb-2">
        <label for="tenDem" class="form-label">Tên Đệm</label>
        <input type="text" class="form-control" id="tenDem" name="tenDem" value="${nv.tenDem}">
    </div>
    <div class="mb-2">
        <label for="ho" class="form-label">Họ</label>
        <input type="text" class="form-control" id="ho" name="ho" value="${nv.ho}">
    </div>
    <div class="mb-2">
        <div class="form-check">
            <input value="Nam" class="form-check-input" type="radio" name="gioiTinh"
                   id="flexRadioDefault1" ${nv.gioiTinh == "Nam" ? 'checked' : ''}>
            <label class="form-check-label" for="flexRadioDefault1">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input value="Nữ" class="form-check-input" type="radio" name="gioiTinh"
                   id="flexRadioDefault2" ${nv.gioiTinh == "Nữ" ? 'checked' : ''}>
            <label class="form-check-label" for="flexRadioDefault2">
                Nữ
            </label>
        </div>
    </div>
    <div class="mb-2">
        <label for="ngaySinh" class="form-label">Ngày Sinh</label>
        <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="${ngaySinh}">
    </div>
    <div class="mb-2">
        <label for="diaChi" class="form-label">Địa Chỉ</label>
        <input type="text" class="form-control" id="diaChi" name="diaChi" value="${nv.diaChi}">
    </div>
    <div class="mb-2">
        <label for="sdt" class="form-label">SĐT</label>
        <input type="number" class="form-control" id="sdt" name="sdt" value="${nv.sdt}">
    </div>
    <div class="mb-2">
        <label for="matKhau" class="form-label">Mật Khẩu</label>
        <input type="text" class="form-control" id="matKhau" name="matKhau" value="${nv.matKhau}">
    </div>
    <div class="mb-2">
        <label for="cuaHang" class="form-label">Cửa Hàng</label>
        <select name="cuaHang" id="cuaHang" class="form-select" aria-label="Default select example">
            <%--        <option selected>Open this select menu</option>--%>
            <c:forEach items="${lstCH}" var="ch">
                <option value="${ch.id}" ${nv.cuaHang.ten == ch.ten ? 'selected' : ''}>${ch.ten}</option>
            </c:forEach>

        </select>
    </div>
    <div class="mb-2">
        <label for="chucVu" class="form-label">Chức Vụ</label>
        <select name="chucVu" id="chucVu" class="form-select" aria-label="Default select example">
            <%--        <option selected>Open this select menu</option>--%>
            <c:forEach items="${lstCV}" var="cv">
                <option value="${cv.id}" ${nv.chucVu.id == cv.id ? 'selected' : ''}>${cv.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2">
        <label for="trangThai" class="form-label">Trạng Thái</label>
        <input type="text" class="form-control" id="trangThai" name="trangThai" value="${nv.trangThai}">
    </div>
    <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-success">Sửa</button>
    </div>
</form>
</body>
</html>
