<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Customer Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Admin-dashboard.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body class="dashboard-page">
<jsp:include page="/WEB-INF/jsp/layout/navbar.jsp">
    <jsp:param name="dashboardTitle" value="Admin Dashboard" />
</jsp:include>
    <div class="dashboard-container">

        <h2 class="welcome-text">Welcome, Admin 👋</h2>

        <div class="card">

            <div class="card">
                <h3>Total Customers</h3>
                <p>Manage registered users</p>
                <a href="${pageContext.request.contextPath}/admin/customers"
                   class="btn btn-orange">
                    View Customers
                </a>
            </div>

            <div class="card">
                <h3>Orders</h3>
                <p>Track and manage orders</p>
                <a href="#" class="btn btn-orange">
                    View Orders
                </a>
            </div>

            <div class="card">
                <h3>Restaurants</h3>
                <p>Manage restaurant partners</p>
                <a href="#" class="btn btn-orange">
                    Manage Restaurants
                </a>
            </div>

        </div>
     </div>

</body>