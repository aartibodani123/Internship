<html>
<head>
    <title>Customer Signup</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Customer-signup.css">
</head>

<body>
<div class="center">
    <div class="card">
        <h2>Create Customer Account</h2>

        <form action="/customers/signup" method="post">
            <input type="text" name="user_name" placeholder="Full Name" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="text" name="phone" placeholder="Phone" required>
            <input type="text" name="address" placeholder="Delivery Address" required>
            <input type="password" name="password" placeholder="Password" required>

            <button class="btn">Sign Up</button>
        </form>
    </div>
</div>
</body>
</html>
