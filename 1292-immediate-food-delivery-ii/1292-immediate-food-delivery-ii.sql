-- SELECT ROUND((Count(customer_id) / (SELECT COUNT(DISTINCT customer_id) FROM Delivery)) * 100, 2) AS immediate_percentage
-- FROM Delivery
-- WHERE order_date = customer_pref_delivery_date and (customer_id, order_date) in (
--   Select customer_id, min(order_date) 
--   from Delivery
--   group by customer_id
-- )

SELECT ROUND(AVG(if(order_date = customer_pref_delivery_date,1,0)) * 100, 2) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN (
    SELECT customer_id, MIN(order_date) 
    FROM Delivery
    GROUP BY customer_id
);
