# Write your MySQL query statement below
-- SELECT visited_on, amount, ROUND(amount/7, 2) average_amount
-- FROM (
--     SELECT DISTINCT visited_on, 
--     SUM(amount) OVER(ORDER BY visited_on RANGE BETWEEN INTERVAL 6 DAY   PRECEDING AND CURRENT ROW) amount, 
--     MIN(visited_on) OVER() as first_date 
--     FROM Customer
-- ) as t
-- WHERE visited_on>= first_date+6;


SELECT DISTINCT visited_on,
       SUM(amount) OVER w AS amount,
       ROUND((SUM(amount) OVER w) / 7, 2) AS average_amount
FROM customer
WINDOW w AS (
    ORDER BY visited_on
    RANGE BETWEEN INTERVAL 6 DAY PRECEDING AND CURRENT ROW
)
LIMIT 999 OFFSET 6;

