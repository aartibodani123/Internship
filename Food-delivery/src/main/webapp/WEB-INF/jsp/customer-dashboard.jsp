<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Dashboard</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }



        .container {
            padding: 20px;
        }

        .card {
            background: white;
            padding: 20px;
            margin-bottom: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        a {
            text-decoration: none;
            color: #ff6f00;
            font-weight: bold;
        }
        .header {
            display: flex;
            align-items: center;
            background-color: #1f2933; /* dark slate */
            color: #ffffff;
            padding: 12px 24px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        .header-left,
        .header-right {
            flex: 1;
        }

        .header-center {
            flex: 2;
            text-align: center;
            font-size: 18px;
            font-weight: bold;
        }

        .logo {
            height: 100px;
            width: auto;
        }



        .logout {
            float: right;
            color: white;
        }
    </style>
</head>

<body>

<header class="header">
    <div class="header-left">
        <img src="${pageContext.request.contextPath}/images/logo.png" alt="Eatzy Logo" class="logo">
    </div>

    <div class="header-center">
        Customer Dashboard
    </div>

    <div class="header-right">
        <!-- future logout / profile -->
    </div>
</header>


<div class="container">

    <div class="card">
        <h2>Welcome, ${user_name}</h2>
        <p>Glad to see you back!</p>
    </div>

    <div class="card">
        <h3>📋 Quick Actions</h3>
        <ul>
            <li><a href="/restaurants/get">Browse Restaurants</a></li>
            <li><a href="/orders/my-orders">My Orders</a></li>
            <li><a href="/customers/profile">My Profile</a></li>
        </ul>
    </div>

    <div class="card">
        <h3>🛒 Recent Orders</h3>
        <p>No recent orders found.</p>
    </div>

</div>

</body>
</html>
