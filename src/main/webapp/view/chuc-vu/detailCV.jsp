<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/28/2023
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin chức vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form action="/chuc-vu/update" method="post" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">ID</label>
        <div class="col-sm-10">
            <input value="${cv.id}" class="form-control" type="text" name="id" disabled><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input value="${cv.ma}" class="form-control" type="text" name="ma"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input value="${cv.ten}" class="form-control" type="text" name="ten"><br>
        </div>
    </div>
    <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-success">Sửa</button>
    </div>
</form>
</body>
</html>
