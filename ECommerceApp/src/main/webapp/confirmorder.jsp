<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%
    // Get today's date
    LocalDate today = LocalDate.now();

    // Add 2 days
    LocalDate deliveryDate = today.plusDays(2);

    // Format date (Example: 28 February 2026)
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    String formattedDate = deliveryDate.format(formatter);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>

    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", sans-serif;
            background: linear-gradient(135deg, #00c6ff, #0072ff);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .success-box {
            background: white;
            padding: 40px;
            width: 450px;
            border-radius: 15px;
            text-align: center;
            box-shadow: 0 15px 40px rgba(0,0,0,0.3);
            animation: fadeIn 0.6s ease-in-out;
        }

        h2 {
            color: #28a745;
            margin-bottom: 20px;
        }

        p {
            font-size: 18px;
            margin-bottom: 15px;
            color: #333;
        }

        .date {
            font-weight: bold;
            color: #0072ff;
            font-size: 20px;
        }

        .btn-home {
            margin-top: 25px;
            padding: 12px 25px;
            border: none;
            border-radius: 25px;
            background: #0072ff;
            color: white;
            font-size: 15px;
            cursor: pointer;
            transition: 0.3s;
        }

        .btn-home:hover {
            background: #0056cc;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>

<body>

<div class="success-box">
    <h2>Order Placed Successfully!</h2>
    <p>Your order has been confirmed.</p>
    <p>Your order will arrive on:</p>
    <p class="date"><%= formattedDate %></p>

    <form action="UserHomeServlet">
        <button class="btn-home">Go to Home</button>
    </form>
</div>

</body>
</html>