<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.ecommerce.model.Product" %>

<%
    Product product = (Product) request.getAttribute("product");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
          rel="stylesheet">
</head>
<style>
    .image-container {
        text-align: center;
        margin-bottom: 20px;
    }

    .product-image {
        max-width: 400px;     /* controls width */
        max-height: 300px;    /* controls height */
        width: auto;
        height: auto;
        object-fit: contain;  /* prevents stretching */
        border-radius: 10px;
    }
</style>

<body style="background-color:#f8f9fa;">

<div class="container mt-5">

    <div class="card shadow-lg p-4 text-center">

        <% if(product != null) { %>

            <!-- ✅ Product Image Added Here -->
          <div class="image-container">
		    <img src="<%= product.getImage() %>" class="product-image">
		</div>

            <h2 class="text-primary mb-4">
                <%= product.getName() %>
            </h2>

            <hr>

            <h4 class="text-success">
                ₹ <%= product.getPrice() %>
            </h4>

            <p class="mt-3">
                <strong>Description:</strong><br>
                <%= product.getDescription() %>
            </p>

            <div class="mt-4">
                <a href="UserHomeServlet" class="btn btn-secondary">Back</a>
                <a href="buy.jsp?id=<%= product.getId() %>" class="btn btn-primary">Buy</a>
            <!--    <button class="btn btn-primary">Buy</button> -->
            </div>

        <% } else { %>

            <h3 class="text-danger">
                Product Not Found!
            </h3>

        <% } %>

    </div>

</div>

</body>
</html>