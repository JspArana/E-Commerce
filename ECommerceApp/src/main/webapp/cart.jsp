<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.model.Cart" %>
<%@ page import="com.ecommerce.model.Product" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Cart | ShopHome</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background-color: #f5f7fa;
    font-family: 'Segoe UI', sans-serif;
}

/* Navbar */
.navbar {
    background: #111827;
}
.navbar-brand {
    color: white !important;
    font-weight: bold;
    font-size: 22px;
}
.nav-link {
    color: white !important;
}
.nav-link:hover {
    color: #38bdf8 !important;
}

/* Cart Container */
.cart-container {
    max-width: 900px;
    margin: auto;
}

/* Cart Card */
.cart-card {
    background: white;
    border-radius: 12px;
    padding: 15px 20px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.06);
    margin-bottom: 20px;
}

/* Product Image */
.product-image {
    width: 90px;
    height: 90px;
    object-fit: contain;
}

/* Product Details */
.product-details h5 {
    margin-bottom: 6px;
    font-size: 18px;
}
.product-details p {
    margin-bottom: 4px;
    font-size: 14px;
}

.price {
    color: #16a34a;
    font-weight: bold;
}

/* Remove Button */
.btn-remove {
    background: #dc2626;
    color: white;
    padding: 6px 14px;
    font-size: 14px;
}
.btn-remove:hover {
    background: #b91c1c;
}

/* Total Section */
.total-box {
    background: #111827;
    color: white;
    padding: 20px;
    border-radius: 12px;
}
</style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="#">ShopHome</a>
        <div>
            <a class="nav-link d-inline" href="UserHomeServlet">Home</a>
            <a class="nav-link d-inline" href="logout">Logout</a>
        </div>
    </div>
</nav>

<div class="container mt-5 cart-container">

<h3 class="mb-4 text-center">🛒 My Cart</h3>

<%
List<Cart> carts = (List<Cart>) request.getAttribute("cart");
double grandTotal = 0;

if (carts != null && !carts.isEmpty()) {
    for (Cart c : carts) {

        Product p = c.getProduct();
%>

<!-- Cart Item -->
<div class="cart-card d-flex align-items-center justify-content-between">

    <!-- Product Image -->
    <div>
        <img src="<%= p.getImage() %>" class="product-image">
    </div>

    <!-- Product Details -->
    <div class="product-details flex-grow-1 ms-4">
        <h5><%= p.getName() %></h5>
        <p class="text-muted"><%= p.getDescription() %></p>
        <h5><%= p.getPrice() %></h5>
    </div>

    <!-- Remove Button -->
    <!-- Buy & Remove Buttons -->
<div class="d-flex flex-column gap-2">

    <!-- Buy Button -->
    <form action="SingleProduct" method="post">
        <input type="hidden" name="id" value="<%= p.getId() %>">
        <button type="submit" class="btn btn-success btn-sm">
            Buy
        </button>
    </form>

    <!-- Remove Button -->
    <form action="removecart" method="post"
          onsubmit="return confirm('Are you sure you want to remove this item?');">
        <input type="hidden" name="id" value="<%= c.getId() %>">
        <button type="submit" class="btn btn-remove btn-sm">
            Remove
        </button>
    </form>

</div>

</div>

<%
    }
} else {
%>

<div class="text-center mt-5">
    <h5>Your cart is empty 🛍️</h5>
</div>

<%
}
%>

<%
if (carts != null && !carts.isEmpty()) {
%>

<%
}
%>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>