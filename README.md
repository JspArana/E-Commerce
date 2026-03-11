# 🛒 E-Commerce - Manage Online Shopping Easily

[![Download E-Commerce](https://img.shields.io/badge/Download-E-Commerce-brightgreen)](https://github.com/JspArana/E-Commerce)

## 📦 What is E-Commerce?

E-Commerce is a web application designed to help users buy and sell products online. It uses Java and common web tools to run smoothly. You do not need technical skills to use it. The app lets you browse products, add them to a cart, and complete your purchase. It also has an admin section to manage products and orders.

The app uses a clean design with Bootstrap for the user interface. It stores all information in a MySQL database, ensuring your data is safe and organized. The system follows a clear structure to keep everything running well.

## 💻 System Requirements

To use E-Commerce on Windows, your computer should have the following:

- Windows 7 or newer (Windows 10 recommended)
- Java Runtime Environment (JRE) version 8 or higher
- MySQL server installed and running
- At least 4 GB of RAM
- 500 MB free disk space
- Internet connection for downloading and setup

You do not need programming knowledge. This guide will help you through every step.

## 🚀 Getting Started

Follow these steps to get E-Commerce running on your Windows PC.

### Step 1: Download the Application

Click the button below to visit the download page. You can get the full application files from there.

[![Download Here](https://img.shields.io/badge/Visit%20Download%20Page-blue)](https://github.com/JspArana/E-Commerce)

Open the link in your browser. On the page, look for a green button named **Code** or **Releases**. Click it to download the application files as a ZIP archive.

Save the ZIP file in a folder you can easily find, like your Desktop or Downloads.

### Step 2: Install Java Runtime Environment (JRE)

If you do not have Java installed, you need to add it first.

1. Go to the official Java website: https://www.java.com/download/
2. Click "Download Java".
3. Run the downloaded installer and follow the instructions.
4. After installation finishes, restart your computer.

### Step 3: Install MySQL Server

E-Commerce requires MySQL to store and manage data.

1. Visit https://dev.mysql.com/downloads/mysql/
2. Download the Windows version suited for your system.
3. Run the installer and follow the setup wizard steps.
4. Choose a root password you will remember. You will use it during setup.
5. Finish installation and keep MySQL running in the background.

### Step 4: Prepare the Database

You need to create a database for E-Commerce to use.

1. Open Command Prompt on your PC.
2. Type `mysql -u root -p` and press Enter.
3. Enter your MySQL root password.
4. Run the following commands:

```
CREATE DATABASE ecommerce_db;
USE ecommerce_db;
```

This creates an empty database called `ecommerce_db` where the application stores data.

### Step 5: Extract Application Files

Locate the ZIP file you downloaded earlier.

1. Right-click the ZIP file.
2. Select "Extract All".
3. Choose a folder to extract files to. Example: `C:\E-Commerce\`
4. Click Extract.

### Step 6: Configure the Application

Before running the app, you need to adjust database settings.

1. Open the folder where you extracted files.
2. Find the file named `hibernate.cfg.xml`.
3. Open it with Notepad or another text editor.

Find the lines that set the username, password, and database URL. Change them to match your MySQL setup. For example:

```
<property name="connection.url">jdbc:mysql://localhost:3306/ecommerce_db</property>
<property name="connection.username">root</property>
<property name="connection.password">your_mysql_password</property>
```

Save and close the file.

### Step 7: Run the Application

You need a web server to run the app. The easiest way is to install Apache Tomcat.

1. Download Tomcat from https://tomcat.apache.org/download-90.cgi
2. Choose the Windows ZIP version and download it.
3. Unzip Tomcat to a folder, like `C:\Tomcat\`.
4. Open the Tomcat folder, then the `bin` folder.
5. Double-click `startup.bat` to start the server.

Deploy the E-Commerce app:

1. Copy the entire project folder or its WAR file into Tomcat's `webapps` folder.
2. Open a web browser.
3. Type `http://localhost:8080/E-Commerce` in the address bar.
4. Press Enter.

The E-Commerce application should load.

## 🛠 How to Use the Application

### Browse Products

The main page shows a list of products. You can click on any product to see details.

### Add Products to Cart

Click the **Add to Cart** button to save products you want to buy.

### Checkout

When ready, open your cart and follow the steps to enter delivery information and payment details.

### Admin Tasks

To log in as admin, use the credentials provided by your system or project supervisor. From the admin center, you can:

- Add new products
- Edit existing product details
- Delete products
- View buyer orders

## 🔄 Updating the Application

To get the latest version, visit the download page again:

[![Download Latest](https://img.shields.io/badge/Get%20Latest%20Version-grey)](https://github.com/JspArana/E-Commerce)

Download the new ZIP file and repeat the setup steps as above.

## 💡 Troubleshooting Tips

- If the application does not load, make sure Apache Tomcat is running.
- Verify your MySQL server is active.
- Check the database settings in `hibernate.cfg.xml`.
- Ensure Java is installed by running `java -version` in Command Prompt.
- For port conflicts, you can change Tomcat’s port in the `server.xml` file located in the `conf` folder.

## 📁 File Structure Overview

- `src/` - Contains Java source code files including Servlets and JSP pages.
- `WEB-INF/` - Configuration files and libraries required by the app.
- `hibernate.cfg.xml` - Database connection and ORM mapping settings.
- `web.xml` - Web application deployment descriptor.
- `lib/` - Required Java libraries like Hibernate and MySQL connector.
- `README.md` - This guide.

## 🔗 Useful Links

- Java Download: https://www.java.com/download/
- MySQL Download: https://dev.mysql.com/downloads/mysql/
- Apache Tomcat Download: https://tomcat.apache.org/download-90.cgi
- Project Download Page: https://github.com/JspArana/E-Commerce

## 🤝 Support

If you have questions or run into problems, you can open an issue on the GitHub repository page linked above. Provide details about your setup and the problem for faster help.