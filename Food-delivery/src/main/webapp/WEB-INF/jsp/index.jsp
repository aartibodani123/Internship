<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Eatzy</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="center">

<div class="card">
    <img src="${pageContext.request.contextPath}/images/logo.png"
         alt="FoodieExpress Logo"
         class="logo">
    <p>Fast • Fresh • Reliable</p>

    <a href="${pageContext.request.contextPath}/customers/login" class="btn">Customer</a>
    <a href="${pageContext.request.contextPath}/delivery/login" class="btn btn-alt">Delivery Partner</a>

</div>

</body>
</html>
