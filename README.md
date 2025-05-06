# OrderProcessingSystem
This is a springboot based application to handle the customer orders.
It exposes 2 REST end points:
1. POST to generate the order which saves the order to DB (H2 embedded) and send it to the messaging queue(ActiveMQ embedded)
2. GET to get all the saved orders

Along with that the POSTMAN collection to test the application is also available here: https://github.com/DraegoG/OrderProcessingSystem/blob/main/OrderProcessingSystem_postman_collection.json
