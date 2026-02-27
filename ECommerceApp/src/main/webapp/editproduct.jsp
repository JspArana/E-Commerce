<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Product | Admin Panel</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #4e73df, #1cc88a);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            width: 400px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 15px;
        }

        input, textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        textarea {
            resize: none;
            height: 80px;
        }

        button {
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            background-color: #4e73df;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2e59d9;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>Edit Product</h2>

    <form action="EditProduct" method="post">

        <!-- Hidden ID (important for updating) -->
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

        <label>New Product Name</label>
        <input type="text" name="name" placeholder="Enter new product name" required>

        <label>New Price</label>
        <input type="number" step="0.01" name="price" placeholder="Enter new price" required>

        <label>New Description</label>
        <textarea name="description" placeholder="Enter new description" required></textarea>

        <button type="submit">Update Product</button>

    </form>
</div>

</body>
</html>