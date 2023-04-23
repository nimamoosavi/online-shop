# online shop

This project is a small and expandable project and design Service-Oriented Architecture (SOA)
that allows you to create a small online shop with sales,payment, shipping, warehouse service.

![online_shop Diagram](https://github.com/nimamoosavi/online-shop/wiki/images/Onlien-shop.png)

### Domains and Context

- **Sales**
    - manage products for sale
    - categorize a product
    - update a product
    - change a product price
    - manage user carts
    - manage order rules such as time and discount

- **Warehouse**
    - manage goods quantity
    - packing the orders

- **Payment**
    - manage payments

- **Shipping**
    - dispatch the orders

- **User**
    - manage users
    - manage user rules

### Event Workflow

The communication among all domains is implemented via events and handled with spring context


- **Sales**
  - Cart
  - Catalog
  - Order

### Cart

cart context handles all user baskets

### Catalog

the catalog has two part Category and Product and handles the overview of products

![catalog Diagram](https://github.com/nimamoosavi/online-shop/wiki/images/catalog.png)

### Order

the service that handles the orders then sends event to Payment service


- **Warehouse**
  - stock
  - packing

### stock

this part of warehouse use for managing the quantity of goods

### packing

when all orders left the stock, the packing department packs the box with breakable or normal pack rules
the publish an event to sales for pack ready status


- **Payment**
  - Payment
  - Contradiction

### payment

this part of the System used for order payment,
but we must implement the third party service such as PayPal, primary cart and ..

### Contradiction

this part of the system is used to resolve the contradiction of the order systematically or manually


**Shipping**
  - dispatch and delivery

this part of the system handles the delivery and dispatching packs


### Requirements
The library works with Java 11+ and spring boot version 2.7 and higher
Service Requirement: mysql or another rdbms database

### Docker
in the docker folder, I created a sample of service that you want to start the program,
and you can run it with installation the docker and run with
docker compose up command
