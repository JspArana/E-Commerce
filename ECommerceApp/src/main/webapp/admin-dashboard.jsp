<%@ page import="java.util.*, com.ecommerce.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Dashboard</title>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Segoe UI', sans-serif;
    background: #f4f6f9;
}

/* HEADER */
.header {
    background: #1e3a8a;
    color: white;
    padding: 20px 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.header h2 {
    font-weight: 500;
}

.add-btn {
    background: white;
    color: #1e3a8a;
    padding: 8px 15px;
    border-radius: 5px;
    text-decoration: none;
    font-weight: bold;
    transition: 0.3s;
}

.add-btn:hover {
    background: #dbeafe;
}

/* PRODUCT GRID */
.container {
    padding: 40px;
}

.product-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
    gap: 25px;
}

/* PRODUCT CARD */
.product-card {
    background: white;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.08);
    padding: 20px;
    transition: 0.3s;
}

.product-card:hover {
    transform: translateY(-5px);
}

.product-card img {
    width: 100%;
    height: 180px;
    object-fit: cover;
    border-radius: 10px;
}

.product-name {
    font-size: 18px;
    font-weight: 600;
    margin: 15px 0 5px;
}

.product-price {
    color: #16a34a;
    font-weight: bold;
    font-size: 16px;
    margin-bottom: 8px;
}

.product-desc {
    font-size: 14px;
    color: #555;
    margin-bottom: 15px;
}

/* BUTTONS */
.card-buttons {
    display: flex;
    justify-content: space-between;
}

.btn {
    padding: 6px 12px;
    border-radius: 5px;
    text-decoration: none;
    font-size: 13px;
    font-weight: 500;
}

.edit-btn {
    background: #3b82f6;
    color: white;
}

.delete-btn {
    background: #ef4444;
    color: white;
}

.edit-btn:hover {
    background: #2563eb;
}

.delete-btn:hover {
    background: #dc2626;
}

/* EMPTY MESSAGE */
.empty-msg {
    text-align: center;
    font-size: 18px;
    color: #777;
}
</style>
</head>

<body>

<div class="header">
    <h2>Admin Product Dashboard</h2>
    <a href="admin-add-product.jsp" class="add-btn">+ Add Product</a>
</div>

<div class="container">

<%
List<Product> products = (List<Product>) request.getAttribute("products");

if(products != null && !products.isEmpty()) {
%>

    <div class="product-grid">

<%
    for(Product p : products) {
%>

        <div class="product-card">

            <img src="<%= p.getImage() %>" alt="Product Image">

            <div class="product-name"><%= p.getName() %></div>

            <div class="product-price"><%= p.getPrice() %></div>

            <div class="product-desc">
                <%= p.getDescription() %>
            </div>

            <div class="card-buttons">
                <a href="editproduct.jsp?id=<%= p.getId() %>" class="btn edit-btn">Edit</a>
               <form action="DeleteProduct" method="post" style="display:inline;">
			    <input type="hidden" name="id" value="<%= p.getId() %>">
			    <button type="submit" class="btn delete-btn"
			        onclick="return confirm('Are you sure you want to delete this product?')">
			        Delete
			    </button>
			</form>
            </div>

        </div>

<%
    }
%>

    </div>

<%
} else {
%>

    <div class="empty-msg">
        No products available. Please add a product.
    </div>

<%
}
%>

</div>

</body>
</html>
