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
    <title>Thông tin chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form action="/ctsp/update" method="post" class="container">
    <div class="mb-2">
        <label for="id" class="form-label">ID</label>
        <input type="text" class="form-control" id="id" name="id" disabled value="${ctsp.id}">
    </div>
    <div class="mb-2">
        <label for="sanPham" class="form-label">Sản Phẩm</label>
        <select name="sanPham" id="sanPham" class="form-select" aria-label="Default select example">
            <%--        <option selected>Open this select menu</option>--%>
            <c:forEach items="${lstSP}" var="sp">
                <option value="${sp.id}" ${ctsp.sanPham.id == sp.id ? 'selected' : ""}>${sp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2">
        <label for="nsx" class="form-label">Nhà Sản Xuất</label>
        <select name="nsx" id="nsx" class="form-select" aria-label="Default select example">
            <%--        <option selected>Open this select menu</option>--%>
            <c:forEach items="${lstNSX}" var="nsx">
                <option value="${nsx.id}" ${ctsp.nsx.id == nsx.id ? 'selected' : ""}>${nsx.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2">
        <label for="mauSac" class="form-label">Màu Sắc</label>
        <select name="mauSac" id="mauSac" class="form-select" aria-label="Default select example">
            <%--        <option selected>Open this select menu</option>--%>
            <c:forEach items="${lstMS}" var="ms">
                <option value="${ms.id}" ${ctsp.mauSac.id == ms.id ? 'selected' : ""}>${ms.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2">
        <label for="dongSP" class="form-label">Dòng Sản Phẩm</label>
        <select name="dongSP" id="dongSP" class="form-select" aria-label="Default select example">
            <%--        <option selected>Open this select menu</option>--%>
            <c:forEach items="${lstDSP}" var="dsp">
                <option value="${dsp.id}" ${ctsp.dongSP.id == dsp.id ? 'selected' : ""}>${dsp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2">
        <label for="namBH" class="form-label">Năm Bảo Hành</label>
        <input type="text" class="form-control" id="namBH" name="namBH" value="${ctsp.namBH}">
    </div>
    <div class=" mb-2">
        <label for="moTa" class="form-label">Mô Tả</label>
        <input type="text" class="form-control" id="moTa" name="moTa" value="${ctsp.moTa}">
    </div>
    <div class=" mb-2">
        <label for="soLuongTon" class="form-label">Số Lượng Tồn</label>
        <input type="number" class="form-control" id="soLuongTon" name="soLuongTon" value="${ctsp.soLuongTon}">
    </div>
    <div class=" mb-2">
        <label for="giaNhap" class="form-label">Giá Nhập</label>
        <input type="number" class="form-control" id="giaNhap" name="giaNhap" value="${ctsp.giaNhap}">
    </div>
    <div class=" mb-2">
        <label for="giaBan" class="form-label">Giá Bán</label>
        <input type="number" class="form-control" id="giaBan" name="giaBan" value="${ctsp.giaBan}">
    </div>
    <div class=" col-md-12 text-center">
        <button type="submit" class="btn btn-success">Sửa</button>
    </div>
</form>
</body>
</html>
