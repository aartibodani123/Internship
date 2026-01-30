<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Restaurants</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h2>Available Restaurants</h2>
<c:forEach var="r" items="${restaurants}">
    <div style="border:1px solid #ccc; padding:10px; margin:10px">
        <h3>${r.name}</h3>
        <p>Location: ${r.address}</p>
        <p>Contact: ${r.phone}</p>
    </div>
</c:forEach>
</body>
</html>