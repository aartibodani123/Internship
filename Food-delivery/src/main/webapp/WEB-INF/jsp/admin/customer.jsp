<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin | Customers</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1.css">
    <!-- DataTables CSS -->
    <link rel="stylesheet"
          href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css"/>

    <!-- jQuery (already added but ensure it’s before DataTables) -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>

    <style>
        .dataTables_wrapper .dataTables_paginate .paginate_button.current {
            background-color: #ff6b00 !important;
            color: white !important;
        }
        body {
            background-color: #fff8f2;
            font-family: "Segoe UI", sans-serif;
        }

        .page-container {
            padding: 40px;
        }

        .table thead {
            background-color: #ff6b00;
            color: white;
        }

        .btn-orange {
            background-color: #ff6b00;
            color: white;
            border: none;
        }

        .btn-orange:hover {
            background-color: #e65c00;
        }
    </style>
</head>
<script>
    $(document).ready(function () {
        $('#customerTable').DataTable({
            pageLength: 5,
            lengthMenu: [5, 10, 20, 50],
            ordering: true
        });
    });
</script>

<body>
<jsp:include page="/WEB-INF/jsp/layout/navbar.jsp">
    <jsp:param name="navTitle" value="Customer Information" />
</jsp:include>
<div class="container page-container">

    <h3 class="mb-4">👥 Customer Management</h3>

    <table id="customerTable"
    class="table table-bordered table-hover shadow-sm">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="customer" items="${customerPage.content}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Pagination -->


</div>

</body>
</html>
