<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Restaurants</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>

<body>

<h2>Restaurant List</h2>

<table id="restaurantTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>City</th>
        <th>State</th>
        <th>Phone</th>
        <th>Rating</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>

<div class="pagination" id="pagination"></div>

<script>
alert("SCRIPT EXECUTED");

    let currentPage = 0;
    const pageSize = 5;

    function loadRestaurants(page) {
        currentPage = page;

        $.ajax({
            url: "/api/restaurants",
            type: "GET",
            dataType: "json",
            data: {
                page: page,
                size: pageSize
            },
            success: function (response) {

                let tbody = $("#restaurantTable tbody");
                tbody.empty();

                if (!response || !response.content) {
                    alert("response or response.content is undefined");
                    return;
                }

                response.content.forEach(r => {
                    tbody.append(
                        "<tr>" +
                        "<td>" + r.id + "</td>" +
                        "<td>" + r.name + "</td>" +
                        "<td>" + r.city + "</td>" +
                        "<td>" + r.state + "</td>" +
                        "<td>" + r.phone + "</td>" +
                        "<td>" + r.rating + "</td>" +
                        "<td>" + (r.active ? "Active" : "Inactive") + "</td>" +
                        "</tr>"
                    );
                });
                renderPagination(response.totalPages, response.number );
            },

            error: function () {
                alert("Failed to load restaurants");
            }
        });
    }

    function renderPagination(totalPages, current) {
        let pagination = $("#pagination");
        pagination.empty();

        for (let i = 0; i < totalPages; i++) {
            let btn = $("<button>")
                .text(i + 1)
                .click(() => loadRestaurants(i));

            if (i === current) {
                btn.css({ background: "#ff9800", color: "white" });
            }

            pagination.append(btn);
        }
    }

    loadRestaurants(0);
</script>



</body>
</html>
