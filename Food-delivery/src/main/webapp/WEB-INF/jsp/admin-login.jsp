<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Eatzy | Food Delivery</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1.css">
</head>
<body>
<form action="/admin/process-login" method="post">

    <input type="email" name="email" placeholder="Admin Email" />
    <input type="password" name="password" placeholder="Password" />

    <button type="submit">Login</button>

    <c:if test="${param.error != null}">
        <p style="color:red">Invalid credentials</p>
    </c:if>
</form>
</body>
