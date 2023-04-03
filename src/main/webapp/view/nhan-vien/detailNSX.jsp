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
    <title>Thông tin nhà sản xuất</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form action="/nsx/update" method="post" class="container">
    <div class="mb-2">
        <label for="id" class="form-label">ID</label>
        <input type="text" class="form-control" id="id" name="id" value="${nsx.id}" disabled>
    </div>
    <div class="mb-2">
        <label for="ma" class="form-label">Mã</label>
        <input type="text" class="form-control" id="ma" name="ma" value="${nsx.ma}">
    </div>
    <div class="mb-2">
        <label for="ten" class="form-label">Tên</label>
        <input type="text" class="form-control" id="ten" name="ten" value="${nsx.ten}">
    </div>
    <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-success">Sửa</button>
    </div>
</form>
</body>
</html>
