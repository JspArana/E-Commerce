🛒 E-Commerce Web Application

A dynamic E-Commerce Web Application built using Java, JSP, Servlets, Hibernate, and MySQL.
The application allows users to browse products, add items to cart, and place orders, while the admin can manage products efficiently.

📌 Features
👤 User Features

User Registration and Login

Browse available products

Add products to cart

View cart items

Place orders

Order confirmation page

🛠 Admin Features

Admin login

Add new products

Edit product details

Delete products

Manage product listings

🧰 Technologies Used

Frontend

HTML5

CSS3

Bootstrap

Backend

Java

JSP

Servlets

Framework & Tools

Hibernate ORM

Maven

Apache Tomcat

Database

MySQL

📂 Project Structure
E-Commerce/
│
├── src/main/java
│   ├── com.ecommerce.dao
│   ├── com.ecommerce.model
│   ├── com.ecommerce.servlet
│   └── com.ecommerce.util
│
├── src/main/webapp
│   ├── css
│   ├── images
│   ├── jsp
│   ├── index.html
│   └── WEB-INF
│       └── web.xml
│
└── pom.xml


⚙️ Setup Instructions


1️⃣ Clone the Repository
git clone https://github.com/your-username/ecommerce-project.git
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
