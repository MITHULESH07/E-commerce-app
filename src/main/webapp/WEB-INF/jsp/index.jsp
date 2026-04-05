<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Order Management Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
<body>

<nav class="navbar">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index">&#128722; OrderManager</a>
    <ul class="navbar-nav">
        <li><a href="${pageContext.request.contextPath}/orders">View Orders</a></li>
        <li><a href="${pageContext.request.contextPath}/orders/add">+ Add Order</a></li>
    </ul>
</nav>

<div class="container">
    <h2 class="page-title">E-Commerce Order Management System</h2>

    <div class="card">
        <p style="font-size: 1rem; color: #555; margin-bottom: 1.5rem;">
            Manage customer orders using the required add, view, update, delete, and search features.
        </p>

        <div style="display: flex; gap: 0.8rem; flex-wrap: wrap;">
            <a href="${pageContext.request.contextPath}/orders/add" class="btn btn-primary">Add Order</a>
            <a href="${pageContext.request.contextPath}/orders" class="btn btn-success">View Orders</a>
        </div>
    </div>
    
    <div class="stats-row">
        <div class="stat-card">
            <div class="stat-label">Feature 1</div>
            <div class="stat-value" style="font-size: 1rem;">Add Order</div>
        </div>
        <div class="stat-card">
            <div class="stat-label">Feature 2</div>
            <div class="stat-value" style="font-size: 1rem;">View / Search</div>
        </div>
        <div class="stat-card">
            <div class="stat-label">Feature 3</div>
            <div class="stat-value" style="font-size: 1rem;">Update / Delete</div>
        </div>
    </div>
</div>

</body>
</html>
