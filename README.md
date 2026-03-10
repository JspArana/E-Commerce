🛒 E-Commerce Web Application

A dynamic E-Commerce Web Application built using Java, JSP, Servlets, Hibernate, and MySQL.
The application allows users to browse products, add items to cart, and place orders, while the admin can manage products efficiently.

📌 Features

<--------------👤 User Features------------>

1.User Registration and Login

2.Browse available products

3.Add products to cart

4.View cart items

5.Place orders

6.Order confirmation page

<-------------🛠 Admin Features------------>

1.Admin login

2.Add new products

3.Edit product details

4.Delete products

5.Manage product listings

<--------------------🧰 Technologies Used--------------->

1.Frontend

2.HTML5

3.CSS3

4.Bootstrap

Backend

1.Java

2.JSP

3.Servlets

Framework & Tools

1.Hibernate ORM

2.Maven

3.Apache Tomcat

4.Database

5.MySQL




<--------------⚙️ Setup Instructions-------------->


1️⃣ Clone the Repository
git clone [https://github.com/TechyKiran/ecommerce-project.git](https://github.com/TechyKiran/E-Commerce)

2️⃣ Import Project
Import the project into Eclipse / IntelliJ IDEA as a Maven Project.


3️⃣ Configure Database
Create a MySQL database:
CREATE DATABASE ecommerce;
Update database configuration in:
hibernate.cfg.xml


Example:

<property name="hibernate.connection.url">
jdbc:mysql://localhost:3306/ecommerce
</property>

<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">password</property>


4️⃣ Run the Project
Deploy the project on Apache Tomcat Server
Open browser and run:
http://localhost:8080/E-Commerce
