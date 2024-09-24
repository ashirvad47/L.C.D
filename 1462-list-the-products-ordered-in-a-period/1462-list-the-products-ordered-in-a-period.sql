# Write your MySQL query statement below
SELECT product_name, SUM(unit) as unit
FROM Products
JOIN Orders
USING (product_id)
WHERE order_date between  '2020-02-1' and '2020-02-29'
GROUP BY product_id
HAVING SUM(unit) >=100