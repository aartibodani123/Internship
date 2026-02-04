<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body class="login-page">

<div class="login-card">
    <h2 class="title">Welcome Back !</h2>
    <p class="subtitle">Login to your customer account</p>

    <c:if test="${not empty message}">
        <p class="success-msg">${message}</p>
    </c:if>

    <c:if test="${not empty error}">
        <p class="error-msg">${error}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="email" name="username" placeholder="Email" required>

        <input type="password" name="password" placeholder="Password" required>


        <button class="primary-btn">Login</button>
    </form>

    <p class="signup-text">
        New user?
        <a href="${pageContext.request.contextPath}/customers/signup">Sign up</a>
    </p>
</div>

</body>
</html>
