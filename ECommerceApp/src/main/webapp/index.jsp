<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.model.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ShopHome</title>

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
    font-size: 24px;
}
.nav-link {
    color: white !important;
}
.nav-link:hover {
    color: #38bdf8 !important;
}

/* Hero Section */
.hero {
    background: linear-gradient(to right, #1e3a8a, #2563eb);
    color: white;
    padding: 60px 20px;
    text-align: center;
    margin-bottom: 40px;
}
.hero h1 {
    font-size: 40px;
    font-weight: bold;
}
.hero p {
    font-size: 18px;
    margin-top: 10px;
}

/* Product Cards */
.product-card {
    background: white;
    border-radius: 12px;
    padding: 20px;
    transition: 0.3s;
    box-shadow: 0 2px 8px rgba(0,0,0,0.08);
    height: 100%;
}

.product-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 8px 20px rgba(0,0,0,0.15);
}

.product-image {
    height: 180px;
    width: 100%;
    object-fit: contain;
    margin-bottom: 15px;
}

.product-name {
    font-weight: 600;
    font-size: 18px;
    margin-bottom: 8px;
}

.product-price {
    color: #16a34a;
    font-weight: bold;
    font-size: 16px;
    margin-bottom: 8px;
}

.product-description {
    font-size: 14px;
    color: #6b7280;
    margin-bottom: 15px;
}

/* Button Styling */
.btn-buy {
    background: #16a34a;
    color: white;
}

.btn-buy:hover {
    background: #15803d;
    color: white;
}

.button-group {
    display: flex;
    gap: 10px;
    justify-content: center;
}
</style>
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="#">Indoor Decor for Modern Homes</a>
        <div class="ms-auto">
            <a class="nav-link d-inline me-3" href="#">Home</a>
            <a class="nav-link d-inline me-3" href="cartsitems">Cart</a>
            <a class="nav-link d-inline" href="index.html">Logout</a>
        </div>
    </div>
</nav>

<!-- Hero Banner -->
<div class="hero">
    <h1>Welcome to Shop</h1>
    <p>Discover amazing products at unbeatable prices</p>
</div>

<!-- Products Section -->
<div class="container">
    <h3 class="text-center mb-4">Featured Products</h3>
    <div class="row g-4">

        <%
            List<Product> products = (List<Product>) request.getAttribute("Product");
            if(products != null && !products.isEmpty()) {
                for(Product p : products) {
        %>

        <div class="col-lg-3 col-md-4 col-sm-6">
            <div class="product-card text-center">

                <img src="<%= request.getContextPath() + "/" + p.getImage() %>"
                     class="product-image">

                <div class="product-name"><%= p.getName() %></div>

                <div class="product-price">₹ <%= p.getPrice() %></div>

                <div class="product-description">
                    <%= p.getDescription() %>
                </div>

                <!-- Buttons in Single Row -->
                <div class="button-group">

                    <!-- Add To Cart -->
                    <form action="<%= request.getContextPath() %>/addtocart" method="post">
                        <input type="hidden" name="productId" value="<%= p.getId() %>">
                        <button type="submit" class="btn btn-primary btn-sm">
                            Add To Cart
                        </button>
                    </form>

                    <!-- Buy Now -->
                    <form action="<%= request.getContextPath() %>/SingleProduct" method="post">
					    <input type="hidden" name="id" value="<%= p.getId() %>">
					    <button type="submit" class="btn btn-buy btn-sm">
					        Buy Now
					    </button>
					</form>

                </div>

            </div>
        </div>

        <%
                }
            } else {
        %>

        <div class="col-12 text-center">
            <h5>No products available right now.</h5>
        </div>

        <%
            }
        %>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>