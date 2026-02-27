<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.model.Buy" %>
<%@ page import="com.ecommerce.model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buyer Details</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-dark text-white">
            <h4 class="mb-0 text-center">Buyer & Product Details</h4>
        </div>

        <div class="card-body">

            <%
                List<Buy> list = (List<Buy>) request.getAttribute("details");

                if(list != null && !list.isEmpty()) {
            %>

            <div class="table-responsive">
                <table class="table table-bordered table-hover text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>Product Name</th>
                            <th>Price</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Landmark</th>
                            <th>Street</th>
                            <th>City</th>
                            <th>State</th>
                            <th>Country</th>
                        </tr>
                    </thead>
                    <tbody>

                    <%
                        for(Buy b : list) {
                            Product p = b.getProduct();
                    %>

                        <tr>
                            <td><%= (p != null) ? p.getName() : "N/A" %></td>
                            <td><%= (p != null) ? p.getPrice() : "N/A" %></td>
                            <td><%= b.getPhone() %></td>
                            <td><%= b.getEmail() %></td>
                            <td><%= b.getLandmark() %></td>
                            <td><%= b.getStreet() %></td>
                            <td><%= b.getCity() %></td>
                            <td><%= b.getState() %></td>
                            <td><%= b.getCountry() %></td>
                        </tr>

                    <%
                        }
                    %>

                    </tbody>
                </table>
                <div class="text-center mt-4">
			    <form action="<%= request.getContextPath() %>/confirmorder.jsp" method="get"
			   			 onsubmit="return confirm('Are you sure to purchase this Product? we are currently receiving Cash on Delivery Only');">
			        <button type="submit" class="btn btn-success btn-lg">
			            Confirm Purchase
			        </button>
			    </form>
			    
			    
				</div>
            </div>

            <%
                } else {
            %>

            <div class="alert alert-warning text-center">
                No Buyer Details Found.
            </div>

            <%
                }
            %>

        </div>
    </div>
</div>

</body>
</html>