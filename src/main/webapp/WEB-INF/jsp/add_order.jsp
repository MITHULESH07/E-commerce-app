<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Add Order - Order Management</title>
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
    <h2 class="page-title">Add New Order</h2>

    <div class="card" style="max-width: 560px;">
        <form:form action="${pageContext.request.contextPath}/orders/add" method="post" modelAttribute="order">
            <div class="form-group">
                <label for="customerName">Customer Name</label>
                <form:input path="customerName" id="customerName" cssClass="form-control" placeholder="e.g. Mithulesh Kumar"/>
                <form:errors path="customerName" cssClass="invalid-feedback" element="div"/>
            </div>

            <div class="form-group">
                <label for="productName">Product Name</label>
                <form:input path="productName" id="productName" cssClass="form-control" placeholder="e.g. Laptop"/>
                <form:errors path="productName" cssClass="invalid-feedback" element="div"/>
            </div>

            <div class="form-group">
                <label for="quantity">Quantity</label>
                <form:input path="quantity" id="quantity" type="number" cssClass="form-control" placeholder="e.g. 2" min="1"/>
                <form:errors path="quantity" cssClass="invalid-feedback" element="div"/>
            </div>

            <div class="form-group">
                <label for="price">Price (&#8377;)</label>
                <form:input path="price" id="price" type="number" cssClass="form-control" placeholder="e.g. 49999.99" step="0.01" min="0.01"/>
                <form:errors path="price" cssClass="invalid-feedback" element="div"/>
            </div>

            <div style="display: flex; gap: 0.7rem; margin-top: 1.5rem;">
                <button type="submit" class="btn btn-primary">Save Order</button>
                <a href="${pageContext.request.contextPath}/orders" class="btn btn-secondary">Cancel</a>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>
