<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Error - Order Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
<body>
<nav class="navbar">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/orders">&#128722; OrderManager</a>
</nav>
<div class="container">
    <div class="empty-state" style="margin-top: 3rem;">
        <div class="empty-icon">&#9888;</div>
        <h2 style="margin-bottom:0.5rem;">Something went wrong</h2>
        <c:choose>
            <c:when test="${not empty message}">
                <p><c:out value="${message}"/></p>
            </c:when>
            <c:otherwise>
                <p>An unexpected error occurred.</p>
            </c:otherwise>
        </c:choose>
        <a href="${pageContext.request.contextPath}/orders" class="btn btn-primary" style="margin-top: 1rem;">Back to Orders</a>
    </div>
</div>
</body>
</html>
