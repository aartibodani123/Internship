<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Restaurants</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1.css">
</head>

<body class="restaurant-page">

<div class="page-container">

    <h1 class="page-title">🍽 Available Restaurants</h1>

    <div class="restaurant-grid">

        <c:forEach var="restaurant" items="${restaurants}">
            <div class="restaurant-card">

                <h3 class="restaurant-name">
                        ${restaurant.name}
                </h3>

                <p class="restaurant-info">
                    📍 ${restaurant.address}
                </p>

                <p class="restaurant-info">
                    📞 ${restaurant.phone}
                </p>

                <a href="${pageContext.request.contextPath}/restaurants/${restaurant.id}/menu"
                   class="primary-btn small">
                    View Menu
                </a>

            </div>
        </c:forEach>

    </div>

</div>

</body>
</html>
