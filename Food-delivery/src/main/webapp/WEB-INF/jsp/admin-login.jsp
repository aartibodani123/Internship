<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Eatzy | Admin Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1.css">
    <style>
        html, body {
            height: 100%;
            margin: 0;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;

            background:
                linear-gradient(rgba(255,241,230,0.9), rgba(255,241,230,0.9)),
                url("${pageContext.request.contextPath}/images/food-doodles.png");

            background-size: cover;
            background-position: center;
            font-family: "Segoe UI", sans-serif;
        }

        .login-card {
            width: 420px;
            background: #ffffff;
            padding: 60px 45px;
            border-radius: 28px;
            box-shadow: 0 20px 50px rgba(0,0,0,0.08);
            text-align: center;
        }

        .top-section {
            margin-bottom: 35px;
        }


        .badge-admin {
            display: inline-block;
            background: #fff4e6;
            color: #ff6b00;
            padding: 6px 16px;
            border-radius: 25px;
            font-size: 13px;
            font-weight: 500;
        }

        .subtitle {
            margin-top: 25px;
            font-size: 15px;
            color: #6c757d;
        }

        .form-control {
            border-radius: 14px;
            padding: 14px;
            margin-bottom: 18px;
            border: 1px solid #eee;
            transition: 0.2s;
        }

        .form-control:focus {
            border-color: #ff6b00;
            box-shadow: 0 0 0 2px rgba(255,107,0,0.15);
        }

        .btn-login {
            width: 100%;
            padding: 14px;
            border-radius: 14px;
            border: none;
            background: #ff6b00;
            color: white;
            font-weight: 600;
            font-size: 15px;
            transition: 0.3s ease;
        }

        .btn-login:hover {
            background: #e65c00;
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(255,107,0,0.25);
        }

        .error-text {
            color: red;
            margin-top: 12px;
            font-size: 14px;
        }
    </style>
</head>

<body>

<div class="login-card">

    <div class="top-section">
    <img src="${pageContext.request.contextPath}/images/logo.png"
         alt="Eatzy Logo"
         class="logo"
         height="100">
        <br>
        <span class="badge-admin">🔐 Secure Admin Access</span>
    </div>

    <p class="subtitle">Login to manage restaurants & orders</p>

    <form action="${pageContext.request.contextPath}/admin/process-login" method="post">

        <input type="email" name="email" class="form-control" placeholder="Admin Email" required>

        <input type="password" name="password" class="form-control" placeholder="Password" required>

        <button type="submit" class="btn-login">
            Login to Dashboard
        </button>

        <c:if test="${param.error != null}">
            <div class="error-text">Invalid credentials</div>
        </c:if>

    </form>

</div>

</body>
</html>
