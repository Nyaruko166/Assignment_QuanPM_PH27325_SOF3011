<%--
  Created by IntelliJ IDEA.
  User: Nyaruko
  Date: 3/29/2023
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dòng Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form action="/dong-sp/add" method="post" class="container">
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
    <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-success">Thêm</button>
    </div>
</form>
<section style="text-align: center">
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <td>Id</td>
            <td>Mã</td>
            <td>Tên</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lstDSP}" var="x">
            <tr>
                <td>${x.id}</td>
                <td>${x.ma}</td>
                <td>${x.ten}</td>
                <td><a href="/dong-sp/detail?id=${x.id}" class="btn btn-success">Detail</a>
                    <a href="/dong-sp/delete?id=${x.id}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

</body>
</html>
