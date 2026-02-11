<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Customer Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body class="dashboard-page">

<!-- Navbar -->
<jsp:include page="/WEB-INF/jsp/layout/navbar.jsp">
    <jsp:param name="navTitle" value="Customer Dashboard" />
</jsp:include>


<!-- Main Content -->
<div class="dashboard-container">

    <!-- Welcome Card -->
    <div class="card welcome-card">
        <h2>Welcome, ${user_name} 👋</h2>
        <p>Glad to see you back!</p>
    </div>

    <!-- Quick Actions -->
    <div class="card">
        <h3>⚡ Quick Actions</h3>

        <div class="actions">
            <a href="${pageContext.request.contextPath}/restaurants/get" class="action-btn">
                🍽 Browse Restaurants
            </a>

            <a href="${pageContext.request.contextPath}/orders" class="action-btn">
                📦 My Orders
            </a>

            <a href="${pageContext.request.contextPath}/customers/profile" class="action-btn outline">
                👤 My Profile
            </a>
        </div>
    </div>

    <!-- Recent Orders -->
    <div class="card">
        <h3>🛒 Recent Orders</h3>

        <c:if test="${empty orders}">
            <p class="muted">No recent orders found.</p>
        </c:if>

        <c:if test="${not empty orders}">
            <ul class="order-list">
                <c:forEach var="order" items="${orders}">
                    <li>
                        Order #${order.id} — ₹${order.totalAmount}
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </div>

</div>

</body>
</html>
