# Orders-application
Simple orders application to expose all CRUD api's for orders and products details etc.

DataBase Schema

### Mysql setup for accessing database
```
mysql.server start
mysql -u root
create database order_app;
use order_app;
```
Create tables using the file *create_tables.sql*

Insert dummy data in the tables using *insert_tables.sql*

### Clone the project as a maven project in eclipse.
For running the project - run the main class *OrderAppApplication.java*

### Postman api's
```
https://www.getpostman.com/collections/9eebf7c2aab3f225cb34
```
For placing an order - POST request `http://localhost:8080/orders` from Orders folder and enter customer_id, product_id, quantity in the body.

For getting a particular order details - GET request from Order details folder and enter the order_details_id as `http://localhost:8080/order_details/<id>`

Similar for getting payment or product or customer details.

For getting all order details - same as above without id `http://localhost:8080/order_details`

For cancelling an order - DELETE request from Orders folder `http://localhost:8080/orders/<id>` enter the order_id to be deleted.

