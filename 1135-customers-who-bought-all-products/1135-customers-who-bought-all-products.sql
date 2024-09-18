# Write your MySQL query statement below
-- Select customer_id
-- From Customer
-- Join Product
-- On Customer.product_key = Product.product_key

Select customer_id
From Customer
Group By customer_id
Having Count(distinct product_key)=(Select Count(*) from Product)