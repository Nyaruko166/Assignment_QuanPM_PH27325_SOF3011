<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<section class="container" style="margin: auto">
    <h1>
        <%= "Hello World!" %>
    </h1>
    <br>
    <a href="/khach-hang/view" class="btn btn-info">Hello Khách Hàng</a>
    <a href="/chuc-vu/view" class="btn btn-info">Hello Chức Vụ</a>
    <a href="/cua-hang/view" class="btn btn-info">Hello Cửa Hàng</a>
    <a href="/dong-sp/view" class="btn btn-info">Hello Dòng SP</a>
    <a href="/mau-sac/view" class="btn btn-info">Hello Màu Sắc</a>
</section>
</body>
</html>