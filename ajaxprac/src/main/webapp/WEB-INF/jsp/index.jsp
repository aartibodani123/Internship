<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title>Document</title>
</head>
<body>
<button id="btn">Click Me</button>
<div id="result"></div>

<script>
$("#btn").click(function () {
    $.ajax({
        url: "/hello",
        type: "GET",
        success: function (response) {
            $("#result").text(response);
        }
    });
});
</script>


</body>
</html>
