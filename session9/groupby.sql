select * from orders;
select status from orders
group by status;

select status, count(*) as 'so luong status' from orders
group by status;

select status, sum(quantityOrdered * priceEach) as 'tong tien'
from orders 
inner join orderdetails on orders.orderNumber = orderdetails.orderNumber
group by status;

select orderNumber, sum(quantityOrdered * priceEach) as 'tong tien cac don dat hang'
from orderdetails
group by orderNumber;

select year(orderDate) as year, sum(quantityOrdered * priceEach) as total
from orders 
inner join orderdetails on orders.orderNumber = orderdetails.orderNumber
where status = 'shipped'
group by year
having year > 2003;

