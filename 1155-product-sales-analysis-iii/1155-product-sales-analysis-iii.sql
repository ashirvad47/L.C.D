# Write your MySQL query statement below
Select product_id,year as first_year, quantity, price
From Sales
Where (product_id,year) in ( Select product_id,min(year) from Sales group by product_id)