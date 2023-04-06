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
    <title>Cửa Hàng</title>
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

<form action="/cua-hang/add" method="post" class="container">
    <h2 class="title">Thông Tin Cửa Hàng</h2>
    <%--    <div class="mb-2">--%>
    <%--        <label for="id" class="form-label">ID</label>--%>
    <%--        <input type="text" class="form-control" id="id" name="id" disabled>--%>
    <%--    </div>--%>
    <div class="mb-2">
        <label for="ma" class="form-label">Mã</label>
        <input type="text" class="form-control" id="ma" name="ma">
    </div>
    <div class="mb-2">
        <label for="ten" class="form-label">Tên</label>
        <input type="text" class="form-control" id="ten" name="ten">
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
            <td>Địa Chỉ</td>
            <td>Thành Phố</td>
            <td>Quốc Gia</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lstCH}" var="x">
            <tr>
                <td>${x.id}</td>
                <td>${x.ma}</td>
                <td>${x.ten}</td>
                <td>${x.diaChi}</td>
                <td>${x.thanhPho}</td>
                <td>${x.quocGia}</td>
                <td><a href="/cua-hang/detail?id=${x.id}" class="btn btn-success">Detail</a>
                    <a href="/cua-hang/delete?id=${x.id}" class="btn btn-danger">Delete</a></td>
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
