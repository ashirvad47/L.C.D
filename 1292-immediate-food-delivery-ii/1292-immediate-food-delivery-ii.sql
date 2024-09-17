SELECT ROUND((Count(customer_id) / (SELECT COUNT(DISTINCT customer_id) FROM Delivery)) * 100, 2) AS immediate_percentage
FROM Delivery
WHERE order_date = customer_pref_delivery_date and (customer_id, order_date) in (
  Select customer_id, min(order_date) 
  from Delivery
  group by customer_id
)

