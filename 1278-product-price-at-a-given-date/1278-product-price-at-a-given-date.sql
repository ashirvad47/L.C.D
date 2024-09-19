# Write your MySQL query statement below
-- method 1
SELECT p.product_id, 
     COALESCE(
            (SELECT new_price 
            FROM Products
            WHERE product_id = p.product_id 
                  AND change_date <= '2019-08-16' 
            ORDER BY change_date DESC LIMIT 1), 10) AS price
FROM (SELECT DISTINCT product_id FROM Products) p

-- method 2
-- SELECT DISTINCT product_id, 10 AS price
-- FROM Products
-- WHERE product_id NOT IN (
--   SELECT DISTINCT product_id
--   FROM Products
--   WHERE change_date <= '2019-08-16'
-- )
-- UNION
-- SELECT product_id, new_price AS price
-- FROM Products
-- WHERE (product_id, change_date) IN (
--   SELECT product_id, MAX(change_date) AS date
--   FROM Products
--   WHERE change_date <= '2019-08-16'
--   GROUP BY product_id
-- )