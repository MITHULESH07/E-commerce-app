<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>All Orders - Order Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
<body>

<nav class="navbar">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/orders">&#128722; OrderManager</a>
    <ul class="navbar-nav">
        <li><a href="${pageContext.request.contextPath}/orders">View Orders</a></li>
        <li><a href="${pageContext.request.contextPath}/orders/add">+ Add Order</a></li>
    </ul>
</nav>

<div class="container">
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success"><c:out value="${successMessage}"/></div>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger"><c:out value="${errorMessage}"/></div>
    </c:if>

    <div class="stats-row">
        <div class="stat-card">
            <div class="stat-label">Total Orders</div>
            <div class="stat-value">${fn:length(orders)}</div>
        </div>
        <div class="stat-card">
            <div class="stat-label">Total Revenue</div>
            <div class="stat-value">&#8377;<fmt:formatNumber value="${totalRevenue}" minFractionDigits="2" maxFractionDigits="2"/></div>
        </div>
        <div class="stat-card">
            <div class="stat-label">Unique Products</div>
            <div class="stat-value">${uniqueProductCount}</div>
        </div>
    </div>

    <h2 class="page-title"><c:out value="${pageTitle}"/></h2>

    <form action="${pageContext.request.contextPath}/orders" method="get" class="search-bar">
        <input type="text" name="search" placeholder="Search by customer or product name..." value="${fn:escapeXml(searchKeyword)}"/>
        <button type="submit" class="btn btn-primary">Search</button>
        <a href="${pageContext.request.contextPath}/orders" class="btn btn-secondary">Clear</a>
        <a href="${pageContext.request.contextPath}/orders/add" class="btn btn-success">+ Add Order</a>
    </form>

    <c:if test="${not empty searchMessage}">
        <div class="alert alert-success"><c:out value="${searchMessage}"/></div>
    </c:if>

    <div class="card" style="padding: 0;">
        <div class="table-wrapper">
            <c:choose>
                <c:when test="${not empty orders}">
                    <table>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Order ID</th>
                                <th>Customer Name</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Price (&#8377;)</th>
                                <th>Total (&#8377;)</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${orders}" var="order" varStatus="status">
                                <tr>
                                    <td>${status.index + 1}</td>
                                    <td><span class="badge badge-order">#<c:out value="${order.orderId}"/></span></td>
                                    <td><c:out value="${order.customerName}"/></td>
                                    <td><c:out value="${order.productName}"/></td>
                                    <td><c:out value="${order.quantity}"/></td>
                                    <td><fmt:formatNumber value="${order.price}" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td><fmt:formatNumber value="${order.totalValue}" minFractionDigits="2" maxFractionDigits="2"/></td>
                                    <td>
                                        <div class="action-btns">
                                            <a href="${pageContext.request.contextPath}/orders/edit/${order.orderId}" class="btn btn-warning btn-sm">Edit</a>
                                            <a href="${pageContext.request.contextPath}/orders/delete/${order.orderId}" class="btn btn-danger btn-sm" onclick="return confirm('Delete this order?')">Delete</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <div class="empty-state">
                        <div class="empty-icon">&#128230;</div>
                        <p>No orders found.</p>
                        <a href="${pageContext.request.contextPath}/orders/add" class="btn btn-primary">Add Your First Order</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

</body>
</html>
