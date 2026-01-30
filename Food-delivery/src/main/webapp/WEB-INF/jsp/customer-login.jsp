<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Customer Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="center">

<div class="card">
    <h2>Customer Login</h2>

    <c:if test="${not empty message}">
        <p style="color:green">${message}</p>
    </c:if>

    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/customers/login" method="post">
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>

        <button class="btn">Login</button>
    </form>

    <p>New user? <a href="${pageContext.request.contextPath}/customers/signup">Sign up</a></p>
</div>

</body>
</html>
