# Write your MySQL query statement below
-- SELECT visited_on, amount, ROUND(amount/7, 2) average_amount
-- FROM (
--     SELECT DISTINCT visited_on, 
--     SUM(amount) OVER(ORDER BY visited_on RANGE BETWEEN INTERVAL 6 DAY   PRECEDING AND CURRENT ROW) amount, 
--     MIN(visited_on) OVER() as first_date 
--     FROM Customer
-- ) as t
-- WHERE visited_on>= first_date+6;


select distinct visited_on,
        sum(amount) over w as amount,
        round((sum(amount) over w)/7, 2) as average_amount
    from customer
    WINDOW w AS ( 
            order by visited_on
            range between interval 6 day PRECEDING and current row
    )
    Limit 6, 999