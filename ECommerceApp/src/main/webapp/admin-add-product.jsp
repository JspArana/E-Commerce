<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Add Product</title>
    <link rel="stylesheet" href="admin.css">
</head>
<body>

    <div class="container">

        <h2>Add New Product</h2>

        <form action="addProduct" method="post">

            <div class="form-group">
                <label>Product Name</label>
                <input type="text" name="name" required>
            </div>

            <div class="form-group">
                <label>Price</label>
                <input type="number" step="0.01" name="price" required>
            </div>

            <div class="form-group">
                <label>Image URL</label>
                <input type="text" name="image" required>
            </div>

            <div class="form-group">
                <label>Description</label>
                <textarea name="description" rows="4"></textarea>
            </div>

            <button type="submit">Add Product</button>

        </form>

        <a href="dashboard" class="back-btn">← Back to Dashboard</a>

    </div>

</body>
</html>
