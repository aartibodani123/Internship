<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Customer Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Admin-dashboard.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1.css">
</head>

<body class="dashboard-page">
<jsp:include page="navbar.jsp">
    <jsp:param name="dashboardTitle" value="Admin Dashboard" />
</jsp:include>

</body>