<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Details</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #4e73df, #1cc88a);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            width: 500px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        label {
            font-size: 14px;
            font-weight: bold;
            display: block;
            margin-top: 10px;
            margin-bottom: 5px;
            color: #444;
        }

        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            outline: none;
            transition: 0.3s;
        }

        input:focus {
            border-color: #4e73df;
            box-shadow: 0 0 5px rgba(78, 115, 223, 0.5);
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 20px;
            background-color: #4e73df;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background-color: #2e59d9;
        }

        .error {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>Customer Details</h2>

    <% if(errorMessage != null) { %>
        <div class="error">
            <%= errorMessage %>
        </div>
    <% } %>

    <form action="<%= request.getContextPath() %>/BuyProduct" method="post">
    
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

        <label>Phone</label>
        <input type="tel" name="phone" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Door No</label>
        <input type="text" name="doorno" required>

        <label>Street</label>
        <input type="text" name="street" required>

        <label>Area</label>
        <input type="text" name="area" required>

        <label>Landmark</label>
        <input type="text" name="landmark">

        <label>City</label>
        <input type="text" name="city" required>

        <label>Pincode</label>
        <input type="number" name="pincode" required>

        <label>District</label>
        <input type="text" name="district" required>

        <label>State</label>
        <input type="text" name="state" required>

        <label>Country</label>
        <input type="text" name="country" required>

        <button type="submit">Save Address</button>

    </form>
</div>

</body>
</html>