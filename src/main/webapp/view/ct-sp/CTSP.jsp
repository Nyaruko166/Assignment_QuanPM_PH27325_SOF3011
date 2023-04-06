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
    <title>Chi Tiết Sản Phẩm</title>
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
<form action="/ctsp/add" method="post" class="container">
    <h2 class="title">Thông Tin Chi Tiết SP</h2>
    <%--    <div class="mb-2">--%>
    <%--        <label for="id" class="form-label">ID</label>--%>
    <%--        <input type="text" class="form-control" id="id" name="id" disabled>--%>
    <%--    </div>--%>
    <div class="row">
        <div class="col-6">
            <label for="sanPham" class="form-label">Sản Phẩm</label>
            <select name="sanPham" id="sanPham" class="form-select" aria-label="Default select example">
                <%--        <option selected>Open this select menu</option>--%>
                <c:forEach items="${lstSP}" var="sp">
                    <option value="${sp.id}">${sp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6">
            <label for="nsx" class="form-label">Nhà Sản Xuất</label>
            <select name="nsx" id="nsx" class="form-select" aria-label="Default select example">
                <%--        <option selected>Open this select menu</option>--%>
                <c:forEach items="${lstNSX}" var="nsx">
                    <option value="${nsx.id}">${nsx.ten}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label for="mauSac" class="form-label">Màu Sắc</label>
            <select name="mauSac" id="mauSac" class="form-select" aria-label="Default select example">
                <%--        <option selected>Open this select menu</option>--%>
                <c:forEach items="${lstMS}" var="ms">
                    <option value="${ms.id}">${ms.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6">
            <label for="dongSP" class="form-label">Dòng Sản Phẩm</label>
            <select name="dongSP" id="dongSP" class="form-select" aria-label="Default select example">
                <%--        <option selected>Open this select menu</option>--%>
                <c:forEach items="${lstDSP}" var="dsp">
                    <option value="${dsp.id}">${dsp.ten}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="mb-2">
        <label for="namBH" class="form-label">Năm Bảo Hành</label>
        <input type="text" class="form-control" id="namBH" name="namBH">
    </div>
    <div class="mb-2">
        <label for="moTa" class="form-label">Mô Tả</label>
        <input type="text" class="form-control" id="moTa" name="moTa">
    </div>
    <div class="mb-2">
        <label for="soLuongTon" class="form-label">Số Lượng Tồn</label>
        <input type="number" class="form-control" id="soLuongTon" name="soLuongTon">
    </div>
    <div class="mb-2">
        <label for="giaNhap" class="form-label">Giá Nhập</label>
        <input type="number" class="form-control" id="giaNhap" name="giaNhap">
    </div>
    <div class="mb-2">
        <label for="giaBan" class="form-label">Giá Bán</label>
        <input type="number" class="form-control" id="giaBan" name="giaBan">
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
            <td>Tên Sản Phẩm</td>
            <td>NSX</td>
            <td>Màu Sắc</td>
            <td>Dòng SP</td>
            <td>Năm BH</td>
            <td>Mô Tả</td>
            <td>Số Lượng Tồn</td>
            <td>Giá Nhập</td>
            <td>Giá Bán</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lstCTSP}" var="x">
            <tr>
                <td>${x.id}</td>
                <td>${x.sanPham.ten}</td>
                <td>${x.nsx.ten}</td>
                <td>${x.mauSac.ten}</td>
                <td>${x.dongSP.ten}</td>
                <td>${x.namBH}</td>
                <td>${x.moTa}</td>
                <td>${x.soLuongTon}</td>
                <td>${x.giaNhap}</td>
                <td>${x.giaBan}</td>
                <td><a href="/ctsp/detail?id=${x.id}" class="btn btn-success">Detail</a>
                    <a href="/ctsp/delete?id=${x.id}" class="btn btn-danger">Delete</a></td>
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
