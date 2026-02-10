<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>My Profile</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1.css">
</head>
<body>

<div class="container mt-5">
    <div class="card mx-auto" style="max-width: 500px;">
        <div class="card-body text-center">

            <img src="images/profile.jpg"
                 class="rounded-circle mb-3"
                 width="120" height="120">

            <h4>${user.name}</h4>
            <p class="text-muted">${user.role}</p>

            <hr>

            <p><strong>Email:</strong> ${user.email}</p>

            <a href="editProfile.jsp" class="btn btn-primary mt-3">
                Edit Profile
            </a>
        </div>
    </div>
</div>

</body>
</html>
